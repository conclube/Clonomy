package me.conclure.clonomy.model.generic;

import me.conclure.clonomy.annotations.NonNull;
import me.conclure.clonomy.annotations.ThreadSafe;
import me.conclure.clonomy.misc.util.Nil;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.Function;

@ThreadSafe
public interface CachingRepository<I, T extends DataTransfer<?>> extends Iterable<T> {

    Nil<T> getIfPresent(I identifier);

    T getOrCreate(I identifier);

    Collection<? extends T> getAll();

    <R> Collection<? extends R> applyAndGetAll(Function<? super T, ? extends R> transformer);

    @Override
    Iterator<T> iterator();

    boolean invalidate(I identifier);

    boolean isContained(I identifier);
}