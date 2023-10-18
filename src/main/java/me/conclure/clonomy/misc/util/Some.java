package me.conclure.clonomy.misc.util;

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public final class Some<T> implements Option<T> {


    private final T value;

    public Some(T value) {
        this.value = value;
    }

    @Override
    public T unwrap() {
        return null;
    }

    @Override
    public T unwrapOr(T fallback) {
        return null;
    }

    @Override
    public T unwrapOrElse(Supplier<? extends T> supplier) {
        return null;
    }

    @Override
    public T unwrapOrNull() {
        return null;
    }

    @Override
    public <R> Option<R> map(Function<? super T, ? extends R> function) {
        return null;
    }

    @Override
    public Option<T> inspect(Consumer<? super T> consumer) {
        return null;
    }

    @Override
    public <R> R mapOr(
            R fallback,
            Function<? super T, ? extends R> function
    ) {
        return null;
    }

    @Override
    public <R> R mapOrElse(
            Supplier<? extends R> supplier,
            Function<? super T, ? extends R> function
    ) {
        return null;
    }

    @Override
    public boolean isSome() {
        return false;
    }

    @Override
    public boolean isSomeAnd(Predicate<? super T> predicate) {
        return false;
    }

    @Override
    public boolean isNone() {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
