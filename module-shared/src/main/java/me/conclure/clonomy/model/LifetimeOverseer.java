package me.conclure.clonomy.model;

public interface LifetimeOverseer {
    void registerOwner(LifetimeOwnable lifetime, LifetimeOwner owner);

    void forceDispose(LifetimeOwnable lifetime);

    void dispose(LifetimeOwnable lifetime);
}
