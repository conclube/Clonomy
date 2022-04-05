package me.conclure.clonomy.messaging.redis;

public interface RedisListener {
    void onMessage(RedisMessage message);
}
