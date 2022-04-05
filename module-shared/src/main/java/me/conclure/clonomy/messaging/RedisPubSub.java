package me.conclure.clonomy.messaging;

import redis.clients.jedis.JedisPool;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RedisPubSub implements MessagingCenter {
    private final JedisPool pool;
    private final AtomicReference<State> state;
    private final Lock lock;
    private final Map<String,MessageChannel> channelMap;
    private final Map<MessageChannel,MessageListener[]> listenerMap;

    public RedisPubSub(JedisPool pool) {
        this.pool = pool;
        this.state = new AtomicReference<>(State.UNINITIALIZED);
        this.lock = new ReentrantLock(true);
        this.channelMap = new ConcurrentHashMap<>();
        this.listenerMap = new ConcurrentHashMap<>();
    }

    private void validateState(State state) {
        State expectedState = this.state.get();
        if (expectedState != state) {
            String formatted = "Expected %s but was %s".formatted(expectedState, state);
            throw new IllegalStateException(formatted);
        }
    }

    private void doWhileLocked(Runnable action) {
        this.lock.lock();
        try {
            action.run();
        } finally {
            this.lock.unlock();
        }
    }

    private void doWhileLockedIfValidState(State state, Runnable action) {
        this.validateState(state);
        this.doWhileLocked(() -> {
            this.validateState(state);
            action.run();
        });
    }

    @Override
    public void bootUp() {
        this.doWhileLockedIfValidState(State.UNINITIALIZED, () -> {
            this.state.set(State.REGISTERABLE_RUNNING);
        });
    }

    @Override
    public void disallowNewRegistrations() {
        this.doWhileLockedIfValidState(State.REGISTERABLE_RUNNING, () -> {
            this.state.set(State.UNREGISTERABLE_RUNNING);
        });
    }

    @Override
    public MessageChannel getChannel(String name) {
        return null;
    }

    @Override
    public MessageChannel getChannel(int id) {
        return null;
    }

    @Override
    public void shutdown() {

    }

    private enum State {
        UNINITIALIZED,
        REGISTERABLE_RUNNING,
        UNREGISTERABLE_RUNNING,
        TERMINATED
    }
}
