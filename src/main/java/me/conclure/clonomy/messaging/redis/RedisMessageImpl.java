package me.conclure.clonomy.messaging.redis;

import java.nio.charset.StandardCharsets;

public class RedisMessageImpl implements RedisMessage {
    private final String messageRaw, channel;

    public RedisMessageImpl(String messageRaw, String channel) {
        this.messageRaw = messageRaw;
        this.channel = channel;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String channel() {
        return this.channel;
    }

    @Override
    public String messageRaw() {
        return this.messageRaw;
    }

    public static class Builder {
        private String channel, messageRaw;

        public Builder channel(String channel) {
            this.channel = channel;
            return this;
        }

        public Builder channel(byte[] channel) {
            return this.channel(new String(channel, StandardCharsets.UTF_8));
        }

        public Builder messageRaw(String messageRaw) {
            this.messageRaw = messageRaw;
            return this;
        }

        public Builder messageRaw(byte[] messageRaw) {
            return this.messageRaw(new String(messageRaw,StandardCharsets.UTF_8));
        }

        public RedisMessage build() {
            return new RedisMessageImpl(this.messageRaw, this.channel);
        }
    }
}
