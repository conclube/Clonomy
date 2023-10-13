package me.conclure.clonomy.misc.util;

public final class Some<T> implements Option<T> {
    private final T value;

    public Some(T value) {
        this.value = value;
    }
}
