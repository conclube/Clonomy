package me.conclure.clonomy.messaging.redis;

public interface RedisPubSub {
    void send(RedisMessage redisMessage);

    void registerListener(String channel, RedisListener listener);

    void shutdown();
}
