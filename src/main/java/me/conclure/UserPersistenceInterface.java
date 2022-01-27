package me.conclure;

import java.util.Arrays;
import java.util.Collection;

public interface UserPersistenceInterface {

    void load(UserDataTransfer dataTransfer);

    void save(UserDataTransfer dataTransfer);

    default void saveAll(Collection<? extends UserDataTransfer> dataTransfers) {
        for (UserDataTransfer transfer : dataTransfers) {
            this.save(transfer);
        }
    }

    default void saveAll(UserDataTransfer... dataTransfers) {
        this.saveAll(Arrays.asList(dataTransfers));
    }

    default void loadAll(Collection<? extends UserDataTransfer> dataTransfers) {
        for (UserDataTransfer transfer : dataTransfers) {
            this.load(transfer);
        }
    }

    default void loadAll(UserDataTransfer... dataTransfers) {
        this.loadAll(Arrays.asList(dataTransfers));
    }
}