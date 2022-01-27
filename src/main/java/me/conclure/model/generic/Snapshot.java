package me.conclure.model.generic;

public interface Snapshot<S extends Snapshot<S>> {
    S copy();
}
