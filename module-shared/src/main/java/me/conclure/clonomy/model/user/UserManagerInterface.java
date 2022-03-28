package me.conclure.clonomy.model.user;

import me.conclure.clonomy.annotations.NonNull;
import me.conclure.clonomy.annotations.ThreadSafe;
import me.conclure.clonomy.misc.util.Nil;

import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;

@ThreadSafe
public interface UserManagerInterface {

    UUID getId(UserDataTransfer transfer);

    UserDataTransfer get(UUID id);

    Nil<UserDataTransfer> getIfCached(UUID id);

    boolean isCached(UUID id);

    boolean invalidate(UUID id);

    Collection<? extends UserDataTransfer> getAllCached();

    <R> Collection<? extends R> applyAndGetAllCached(Function<UserDataTransfer, ? extends R> transformer);

    void save(UserDataTransfer transfer);

    void load(UserDataTransfer transfer);

    CompletableFuture<Void> saveAsync(UserDataTransfer transfer);

    CompletableFuture<Void> loadAsync(UserDataTransfer transfer);

    UserDataTransfer loadAndGet(UUID id);

    UserDataTransfer saveAndGet(UUID id);

    CompletableFuture<UserDataTransfer> loadAndGetAsync(UUID id);

    CompletableFuture<UserDataTransfer> saveAndGetAsync(UUID id);

    void loadIfOffline(UserDataTransfer transfer);

    CompletableFuture<Void> loadIfOfflineAsync(UserDataTransfer transfer);

    UserDataTransfer loadIfOfflineAndGet(UUID id);

    CompletableFuture<UserDataTransfer> loadIfOfflineAndGetAsync(UUID id);

    void edit(UUID id, Consumer<UserDataTransfer> consumer);

    void editAsync(UUID id, Consumer<UserDataTransfer> consumer);

    void disableExpiration(UUID id);

    void enableExpiration(UUID id);

    void registerUsage(UUID id);
}