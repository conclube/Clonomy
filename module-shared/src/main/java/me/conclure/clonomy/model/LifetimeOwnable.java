package me.conclure.clonomy.model;

public interface LifetimeOwnable extends Identifiable {

    void mark();

    boolean isMarked();

    void unmark();
}