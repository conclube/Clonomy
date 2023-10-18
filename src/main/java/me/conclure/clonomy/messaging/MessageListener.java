package me.conclure.clonomy.messaging;

public interface MessageListener {
    void onMessage(MessageContext message);

    default void onRegistration(MessagingCenter center) {}

    default void onTermination(MessagingCenter center) {}
}
