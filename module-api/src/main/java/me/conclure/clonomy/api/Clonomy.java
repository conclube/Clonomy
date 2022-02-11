package me.conclure.clonomy.api;

import java.util.Optional;

public abstract class Clonomy {
    private static volatile Clonomy instance;

    public static Optional<Clonomy> getInstance() {
        return Optional.ofNullable(Clonomy.instance);
    }
}