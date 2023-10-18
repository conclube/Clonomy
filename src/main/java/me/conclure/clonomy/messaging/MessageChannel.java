package me.conclure.clonomy.messaging;

import java.util.concurrent.CompletableFuture;

public interface MessageChannel extends AutoCloseable {
    String name();

    int id();

    CompletableFuture<Void> post(Message message);

    RegistrationResult register(MessageListener listener);
}
