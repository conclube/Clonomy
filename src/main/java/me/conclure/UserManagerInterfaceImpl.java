package me.conclure;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class UserManagerInterfaceImpl implements UserManagerInterface {


    @Override
    public CompletableFuture<Void> loadFromStorage(UserDataTransfer dataTransfer) {
        return null;
    }

    @Override
    public CompletableFuture<Void> saveToStorage(UserDataTransfer dataTransfer) {
        return null;
    }

    @Override
    public UserDataTransfer getOrMake(UUID id) {
        return null;
    }

    @Override
    public Optional<UserDataTransfer> getIfPresent(UUID id) {
        return Optional.empty();
    }
}
