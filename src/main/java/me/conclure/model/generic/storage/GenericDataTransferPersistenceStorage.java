package me.conclure.model.generic.storage;

import me.conclure.model.generic.GenericSnapshot;
import me.conclure.model.generic.GenericDataTransfer;

public interface GenericDataTransferPersistenceStorage<D extends GenericDataTransfer<S>,S extends GenericSnapshot<S>> {

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