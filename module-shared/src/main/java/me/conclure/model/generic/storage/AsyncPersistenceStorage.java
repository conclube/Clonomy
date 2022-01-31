package me.conclure.model.generic.storage;

import me.conclure.clonomy.annotations.NonNull;
import me.conclure.clonomy.annotations.ThreadSafe;
import me.conclure.model.generic.DataTransfer;

import java.util.concurrent.CompletableFuture;

@ThreadSafe
@NonNull
public interface AsyncPersistenceStorage<D extends DataTransfer<?>> {
    CompletableFuture<Void> load(D transfer);

    CompletableFuture<Void> save(D transfer);

    CompletableFuture<Void> saveAll(Iterable<? extends D> transfers);

    CompletableFuture<Void> loadAll(Iterable<? extends D> transfers);
}
