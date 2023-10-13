package me.conclure.clonomy.misc.util;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public sealed interface Option<T> extends Iterable<T> permits Some<T> {

    T unwrap();

    T unwrapOr(T fallback);

    T unwrapOrElse(Supplier<? extends T> supplier);

    T unwrapOrNull();

    <R> Option<R> map(Function<? super T, ? extends R> function);

    Option<T> inspect(Consumer<? super T> consumer);

    <R> R mapOr(R fallback, Function<? super T, ? extends R> function);

    <R> R mapOrElse(Supplier<? extends R> supplier, Function<? super T, ? extends R> function);

    boolean isSome();

    boolean isSomeAnd(Predicate<? super T> predicate);

    boolean isNone();
}
