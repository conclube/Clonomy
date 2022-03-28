package me.conclure.clonomy.model.generic.impl;

import me.conclure.clonomy.misc.util.Nil;
import me.conclure.clonomy.model.generic.CachingRepository;
import me.conclure.clonomy.model.generic.DataTransfer;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.Function;

public class CachingDataTransferRepository<I, T extends DataTransfer<?>> implements CachingRepository<I, T> {

    @Override
    public Nil<T> getIfPresent(I identifier) {
        return Nil.absent();
    }

    @Override
    public T getOrCreate(I identifier) {
        return null;
    }

    @Override
    public Collection<? extends T> getAll() {
        return null;
    }

    @Override
    public <R> Collection<? extends R> applyAndGetAll(Function<? super T, ? extends R> transformer) {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public boolean invalidate(I identifier) {
        return false;
    }

    @Override
    public boolean isContained(I identifier) {
        return false;
    }
}
