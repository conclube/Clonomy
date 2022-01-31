package me.conclure.clonomy.api.impl;

import me.conclure.clonomy.api.Clonomy;

import java.util.Optional;

public interface ClonomyBringerHelper {

    static ClonomyBringerHelper create() {
        return new ClonomyBringerHelperImpl();
    }

    void set(Clonomy clonomy);

    Optional<Clonomy> abort();

    Optional<Clonomy> bring();
}