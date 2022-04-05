package me.conclure.clonomy.messaging;

public interface RegistrationResult {
    void awaitTermination();

    default boolean hasFailed() {
        return !this.hasSucceeded();
    }

    boolean hasSucceeded();
}