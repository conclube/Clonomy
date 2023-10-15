package me.conclure.clonomy.model;

public interface GarbageCollectable {

    void mark();

    boolean isMarked();

    void unmark();
}