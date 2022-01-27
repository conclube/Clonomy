package me.conclure.model.user;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public interface UserManagerInterface {

    UUID getId(UserDataTransfer transfer);

    UserDataTransfer get(UUID id);

    Optional<UserDataTransfer> getIfCached(UUID id);

    boolean isCached(UUID id);

    boolean invalidate(UUID id);

    Collection<? extends UserDataTransfer> getAllCached();

    <R> Collection<? extends R> applyAndGetAllCached(Function<UserDataTransfer,? extends R> transformer);

    void saveToStorage(UserDataTransfer transfer);

    void loadFromStorage(UserDataTransfer transfer);

    CompletableFuture<Void> saveToStorageAsync(UserDataTransfer transfer);

    CompletableFuture<Void> loadFromStorageAsync(UserDataTransfer transfer);

    void disableExpiration(UUID id);

    void enableExpiration(UUID id);
}