package me.conclure;

import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;

public interface UserRepository extends Iterator<UserDataTransfer> {

    static UserRepository create() {
        return new UserRepositoryImpl();
    }

    UserDataTransfer getOrCreate(UUID id);

    boolean invalidate(UUID id);

    Collection<? extends UserDataTransfer> getAll();

    <R> Collection<? extends R> applyAndGetAll();
}