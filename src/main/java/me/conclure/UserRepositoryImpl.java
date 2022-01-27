package me.conclure;

import java.util.Collection;
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
    public Collection<? extends UserDataTransfer> all() {
        return null;
    }
}
