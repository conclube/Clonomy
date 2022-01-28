package me.conclure.model.user;

import me.conclure.annotation.NonNull;
import me.conclure.annotation.ThreadSafe;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;

@NonNull
@ThreadSafe
public interface UserManagerInterface {

    UUID getId(UserDataTransfer transfer);

    UserDataTransfer get(UUID id);

    Optional<UserDataTransfer> getIfCached(UUID id);

    boolean isCached(UUID id);

    boolean invalidate(UUID id);

    Collection<? extends UserDataTransfer> getAllCached();

    <R> Collection<? extends R> applyAndGetAllCached(Function<UserDataTransfer, ? extends R> transformer);

    void save(UserDataTransfer transfer);

    void load(UserDataTransfer transfer);

    CompletableFuture<Void> saveAsync(UserDataTransfer transfer);

    CompletableFuture<Void> loadAsync(UserDataTransfer transfer);

    void loadIfOffline(UserDataTransfer transfer);

    CompletableFuture<Void> loadIfOfflineAsync(UserDataTransfer transfer);

    void edit(UUID id, Consumer<UserDataTransfer> consumer);

    void editAsync(UUID id, Consumer<UserDataTransfer> consumer);

    void disableExpiration(UUID id);

    void enableExpiration(UUID id);

    void registerUsage(UUID id);
}