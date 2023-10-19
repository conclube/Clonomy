package me.conclure.clonomy.model.storage.master;

import me.conclure.clonomy.model.User;
import me.conclure.clonomy.model.storage.service.Storage;

public class StandardMasterUserStorage implements MasterUserStorage {
    private final Storage persistenceStorage;
    private final Storage transientStorage;

    public StandardMasterUserStorage(Storage persistenceStorage,
                                     Storage transientStorage
    ) {
        this.persistenceStorage = persistenceStorage;
        this.transientStorage = transientStorage;
    }

    @Override
    public void loadPersistently(User user) {
        var lock = user.readLock();
        lock.lock();
        try {
            this.persistenceStorage.load(user);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void savePersistently(User user) {
        var lock = user.writeLock();
        lock.lock();
        try {
            this.persistenceStorage.save(user);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void loadTransiently(User user) {
        var lock = user.readLock();
        lock.lock();
        try {
            this.transientStorage.load(user);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void saveTransiently(User user) {
        var lock = user.writeLock();
        lock.lock();
        try {
            this.transientStorage.save(user);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void load(User user) {
        var lock = user.readLock();
        lock.unlock();
        try {
            try {
                this.transientStorage.load(user);
            } catch (Exception e) {
                this.persistenceStorage.load(user);
                this.transientStorage.save(user);
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void save(User user) {
        var lock = user.writeLock();
        lock.unlock();
        try {
            try {
                this.transientStorage.save(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                this.persistenceStorage.save(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            lock.unlock();
        }
    }
}
