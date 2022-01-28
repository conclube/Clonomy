package me.conclure.model.generic.impl;

import me.conclure.model.generic.DataTransfer;
import me.conclure.model.generic.Repository;
import me.conclure.model.generic.Snapshot;

import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;
import java.util.function.Function;

public class CachingDataTransferRepository<I, T extends DataTransfer<S>, S extends Snapshot<S>> implements Repository<I, T, S> {

    @Override
    public Optional<T> getIfPresent(I identifier) {
        return Optional.empty();
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
}
