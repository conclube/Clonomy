package me.conclure;

import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public UserDataTransfer getOrCreate(UUID id) {
        return null;
    }

    @Override
    public boolean invalidate(UUID id) {
        return false;
    }

    @Override
    public Collection<? extends UserDataTransfer> getAll() {
        return null;
    }

    @Override
    public <R> Collection<? extends R> applyAndGetAll(Function<? super UserDataTransfer, ? extends R> transformer) {
        return null;
    }

    @Override
    public Collection<? extends UserDataTransfer> all() {
        return null;
    }

    @Override
    public Iterator<UserDataTransfer> iterator() {
        return null;
    }
}
