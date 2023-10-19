package me.conclure.clonomy.model;

import me.conclure.clonomy.misc.util.UUIDIdentifier;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class StandardUser implements User {
    private final UUIDIdentifier identifier;
    private final ReadWriteLock lock;
    private String name;

    public StandardUser(UUIDIdentifier identifier) {
        this.identifier = identifier;
        this.lock = new ReentrantReadWriteLock(true);
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public UUIDIdentifier id() {
        return this.identifier;
    }

    @NotNull
    @Override
    public Lock readLock() {
        return lock.readLock();
    }

    @NotNull
    @Override
    public Lock writeLock() {
        return lock.writeLock();
    }
}
