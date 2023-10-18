package me.conclure.clonomy.messaging.redis;

import redis.clients.jedis.BinaryJedisPubSub;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RedisPubSubImpl implements RedisPubSub {
    private final JedisPool pool;
    private final Lock lock;
    private final Map<String,Set<RedisListenerManager>> listenerManagerMap;
    private final Map<String,BinaryJedisPubSub> pubSubMap;
    private final AtomicBoolean isTerminated;

    public RedisPubSubImpl(JedisPool pool) {
        this.pool = pool;
        this.lock = new ReentrantLock(true);
        this.listenerManagerMap = new HashMap<>();
        this.pubSubMap = new HashMap<>();
        this.isTerminated = new AtomicBoolean(false);
    }

    @Override
    public void send(RedisMessage redisMessage) {
        if (this.isTerminated.get()) {
            throw new IllegalStateException();
        }

        try (Jedis jedis = this.pool.getResource()) {
            byte[] channel = redisMessage.channel().getBytes(StandardCharsets.UTF_8);
            byte[] message = redisMessage.messageRaw().getBytes(StandardCharsets.UTF_8);
            jedis.publish(channel, message);
        }
    }

    @Override
    public void registerListener(String channel, RedisListener listener) {
        if (this.isTerminated.get()) {
            throw new IllegalStateException();
        }

        this.lock.lock();
        try {
            this.pubSubMap.computeIfAbsent(channel, key -> {
                BinaryJedisPubSub pubSub = new BinaryJedisPubSub() {
                    @Override
                    public void onMessage(byte[] channel, byte[] message) {
                        if (RedisPubSubImpl.this.isTerminated.get()) {
                            new IllegalStateException().printStackTrace();
                            return;
                        }
                        RedisMessage redisMessage = RedisMessage.builder()
                                .channel(channel)
                                .messageRaw(message)
                                .build();
                        String channel1 = redisMessage.channel();
                        Set<RedisListenerManager> redisListenerManagers = RedisPubSubImpl.this.listenerManagerMap.get(channel1);

                        if (redisListenerManagers == null) {
                            return;
                        }

                        redisListenerManagers.forEach(redisListenerManager -> {
                            redisListenerManager.listener.onMessage(redisMessage);
                        });
                    }
                };
                Thread thread = new Thread(() -> {
                    try (Jedis jedis = this.pool.getResource()) {
                        jedis.subscribe(pubSub, channel.getBytes(StandardCharsets.UTF_8));
                    }
                });
                thread.setDaemon(true);
                thread.start();
                return pubSub;
            });
            Set<RedisListenerManager> redisListenerManagers = this.listenerManagerMap.computeIfAbsent(channel, key -> new HashSet<>());
            redisListenerManagers.add(new RedisListenerManager(channel, listener));
        } finally {
            this.lock.unlock();
        }
    }

    @Override
    public void shutdown() {
        if (this.isTerminated.get()) {
            throw new IllegalStateException();
        }
        this.lock.lock();
        try {
            if (this.isTerminated.get()) {
                throw new IllegalStateException();
            }
            this.isTerminated.set(true);
            this.listenerManagerMap.clear();
            Iterator<Map.Entry<String, BinaryJedisPubSub>> iterator = this.pubSubMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, BinaryJedisPubSub> next = iterator.next();
                next.getValue().unsubscribe();
                iterator.remove();
            }
            this.pool.close();
        } finally {
            this.lock.unlock();
        }
    }

    record RedisListenerManager(String channel, RedisListener listener) { }
}