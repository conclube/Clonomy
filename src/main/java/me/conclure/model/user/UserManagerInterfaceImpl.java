package me.conclure.model.user;

import me.conclure.model.generic.Cleaner;
import me.conclure.model.generic.IdentifierMapper;
import me.conclure.model.generic.CachingRepository;
import me.conclure.model.generic.storage.AsyncPersistenceStorage;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;

public class UserManagerInterfaceImpl implements UserManagerInterface {
    private final IdentifierMapper<UUID, UserDataTransfer> identifierMapper;
    private final CachingRepository<UUID, UserDataTransfer> repository;
    private final AsyncPersistenceStorage<UserDataTransfer> storage;
    private final Cleaner<UUID> cleaner;

    public UserManagerInterfaceImpl(
            IdentifierMapper<UUID, UserDataTransfer> identifierMapper,
            CachingRepository<UUID, UserDataTransfer> repository,
            AsyncPersistenceStorage<UserDataTransfer> storage,
            Cleaner<UUID> cleaner
    ) {
        this.identifierMapper = identifierMapper;
        this.repository = repository;
        this.storage = storage;
        this.cleaner = cleaner;
    }

    @Override
    public UUID getId(UserDataTransfer transfer) {
        return this.identifierMapper.identifierFrom(transfer);
    }

    @Override
    public UserDataTransfer get(UUID id) {
        return this.repository.getOrCreate(id);
    }

    @Override
    public Optional<UserDataTransfer> getIfCached(UUID id) {
        return this.repository.getIfPresent(id);
    }

    @Override
    public boolean isCached(UUID id) {
        return this.repository.isContained(id);
    }

    @Override
    public boolean invalidate(UUID id) {
        this.enableExpiration(id);
        return this.repository.invalidate(id);
    }

    @Override
    public Collection<? extends UserDataTransfer> getAllCached() {
        return this.repository.getAll();
    }

    @Override
    public <R> Collection<? extends R> applyAndGetAllCached(Function<UserDataTransfer, ? extends R> transformer) {
        return this.repository.applyAndGetAll(transformer);
    }

    @Override
    public void save(UserDataTransfer transfer) {
        this.storage.save(transfer).join();
    }

    @Override
    public void load(UserDataTransfer transfer) {
        this.storage.load(transfer).join();
    }

    @Override
    public CompletableFuture<Void> saveAsync(UserDataTransfer transfer) {
        return this.storage.save(transfer);
    }

    @Override
    public CompletableFuture<Void> loadAsync(UserDataTransfer transfer) {
        return this.storage.load(transfer);
    }

    @Override
    public void loadIfOffline(UserDataTransfer transfer) {

    }

    @Override
    public CompletableFuture<Void> loadIfOfflineAsync(UserDataTransfer transfer) {
        return null;
    }

    @Override
    public void edit(UUID id, Consumer<UserDataTransfer> consumer) {

    }

    @Override
    public void editAsync(UUID id, Consumer<UserDataTransfer> consumer) {

    }

    @Override
    public void disableExpiration(UUID id) {
        this.cleaner.keep(id);
    }

    @Override
    public void enableExpiration(UUID id) {
        this.cleaner.unkeep(id);
    }

    @Override
    public void registerUsage(UUID id) {
        this.cleaner.registerAsFresh(id);
    }
}
