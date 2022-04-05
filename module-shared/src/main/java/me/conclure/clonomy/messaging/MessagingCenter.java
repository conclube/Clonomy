package me.conclure.clonomy.messaging;

import java.util.concurrent.CompletableFuture;

public interface MessagingCenter {
    void bootUp();

    void disallowNewRegistrations();

    MessageChannel getChannel(String name);

    MessageChannel getChannel(int id);

    void shutdown();
}