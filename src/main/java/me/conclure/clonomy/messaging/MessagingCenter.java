package me.conclure.clonomy.messaging;

public interface MessagingCenter {
    void bootUp();

    void disallowNewRegistrations();

    MessageChannel getChannel(String name);

    MessageChannel getChannel(int id);

    void shutdown();
}