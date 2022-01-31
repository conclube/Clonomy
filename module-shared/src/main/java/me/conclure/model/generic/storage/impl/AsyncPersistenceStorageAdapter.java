package me.conclure.model.generic.storage.impl;

import me.conclure.model.generic.DataTransfer;
import me.conclure.model.generic.storage.AsyncPersistenceStorage;
import me.conclure.model.generic.storage.PersistenceStorage;

import java.util.concurrent.CompletableFuture;

public class AsyncPersistenceStorageAdapter<D extends DataTransfer<?>> implements AsyncPersistenceStorage<D> {
    private final PersistenceStorage<D> delegate;

    public AsyncPersistenceStorageAdapter(PersistenceStorage<D> delegate) {
        this.delegate = delegate;
    }

    @Override
    public CompletableFuture<Void> load(D transfer) {
        return null;
    }

    @Override
    public CompletableFuture<Void> save(D transfer) {
        return null;
    }

    @Override
    public CompletableFuture<Void> saveAll(Iterable<? extends D> transfers) {
        return null;
    }

    @Override
    public CompletableFuture<Void> loadAll(Iterable<? extends D> transfers) {
        return null;
    }
}
