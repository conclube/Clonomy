package me.conclure.clonomy.messaging.redis;

import java.nio.charset.StandardCharsets;

public interface RedisMessage {
    static RedisMessageImpl.Builder builder() {
        return RedisMessageImpl.builder();
    }

    String channel();

    default byte[] channelAsBytes() {
        return this.channel().getBytes(StandardCharsets.UTF_8);
    }

    String messageRaw();

    default byte[] messageRawAsBytes() {
        return this.messageRaw().getBytes(StandardCharsets.UTF_8);
    }
}
