package me.conclure.model.generic.storage;

import me.conclure.model.generic.DataTransfer;
import me.conclure.model.generic.Snapshot;

import java.util.concurrent.CompletableFuture;

public class AsyncPersistenceStorageAdapter<D extends DataTransfer<S>,S extends Snapshot<S>> implements AsyncPersistenceStorage<D,S> {
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
