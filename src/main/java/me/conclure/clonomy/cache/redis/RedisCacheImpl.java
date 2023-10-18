package me.conclure.clonomy.cache.redis;

import redis.clients.jedis.JedisPool;

public class RedisCacheImpl implements RedisCache {
    private final JedisPool pool;

    public RedisCacheImpl(JedisPool pool) {
        this.pool = pool;
    }


}
