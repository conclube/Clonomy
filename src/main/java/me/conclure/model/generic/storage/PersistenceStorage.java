package me.conclure.model.generic.storage;

import me.conclure.model.generic.Snapshot;
import me.conclure.model.generic.DataTransfer;

public interface PersistenceStorage<D extends DataTransfer<S>,S extends Snapshot<S>> {

    void load(D transfer);

    void save(D transfer);

    default void saveAll(Iterable<? extends D> transfers) {
        for (D transfer : transfers) {
            this.save(transfer);
        }
    }

    default void loadAll(Iterable<? extends D> transfers) {
        for (D transfer : transfers) {
            this.load(transfer);
        }
    }
}