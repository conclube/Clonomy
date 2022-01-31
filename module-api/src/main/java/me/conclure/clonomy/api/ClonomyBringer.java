package me.conclure.clonomy.api;

import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class ClonomyBringer {
    ClonomyBringer() {
        throw new AssertionError("No ClonomyBringer instances for you :<");
    }

    static volatile Clonomy service;

    static void set(Clonomy service) {
        ClonomyBringer.service = service;
    }

    static Optional<Clonomy> bring() {
        return Optional.ofNullable(ClonomyBringer.service);
    }

    static Optional<Clonomy> abort() {
        Optional<Clonomy> pastService = Optional.ofNullable(ClonomyBringer.service);
        service = null;
        return pastService;
    }
}