package me.conclure.model.generic;

public interface GenericSnapshot<S extends GenericSnapshot<S>> {
    S copy();
}
