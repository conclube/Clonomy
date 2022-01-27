package me.conclure;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface UserManagerInterface {

    static UserManagerInterface create() {
        return new UserManagerInterfaceImpl();
    }

    CompletableFuture<Void> loadFromStorage(UserDataTransfer dataTransfer);

    CompletableFuture<Void> saveToStorage(UserDataTransfer dataTransfer);

    UserDataTransfer getOrMake(UUID id);

    Optional<UserDataTransfer> getIfPresent(UUID id);
}
