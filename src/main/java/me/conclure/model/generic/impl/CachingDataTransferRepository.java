package me.conclure.model.generic.impl;

import me.conclure.model.generic.GenericSnapshot;
import me.conclure.model.generic.GenericDataTransfer;
import me.conclure.model.generic.GenericDataTransferRepository;

import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;
import java.util.function.Function;

public class CachingDataTransferRepository<I, T extends GenericDataTransfer<S>, S extends GenericSnapshot<S>> implements GenericDataTransferRepository<I,T, S> {

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
}
