package me.conclure.model.generic.storage;

import me.conclure.annotation.NonNull;
import me.conclure.annotation.ThreadSafe;
import me.conclure.model.generic.DataTransfer;
import me.conclure.model.generic.Snapshot;

import java.util.concurrent.CompletableFuture;

@ThreadSafe
@NonNull
public interface AsyncPersistenceStorage<D extends DataTransfer<?>> {
    CompletableFuture<Void> load(D transfer);

    CompletableFuture<Void> save(D transfer);

    CompletableFuture<Void> saveAll(Iterable<? extends D> transfers);

    CompletableFuture<Void> loadAll(Iterable<? extends D> transfers);
}
