package me.conclure.model.generic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;
import java.util.function.Function;

public interface GenericDataTransferRepository<I,T extends GenericDataTransfer<S>, S extends GenericSnapshot<S>> extends Iterable<T> {

    Optional<T> getIfPresent(I identifier);

    T getOrCreate(I identifier);

    Collection<? extends T> getAll();

    <R> Collection<? extends R> applyAndGetAll(Function<? super T,? extends R> transformer);

    @Override
    Iterator<T> iterator();
}