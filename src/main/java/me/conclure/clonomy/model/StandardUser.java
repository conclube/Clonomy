package me.conclure.clonomy.model;

import me.conclure.clonomy.misc.util.UUIDIdentifier;

public class StandardUser implements User {
    private final UUIDIdentifier identifier;
    private String name;

    public StandardUser(UUIDIdentifier identifier) {
        this.identifier = identifier;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public UUIDIdentifier id() {
        return this.identifier;
    }
}
