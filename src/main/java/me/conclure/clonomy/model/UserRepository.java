package me.conclure.clonomy.model;

import me.conclure.clonomy.misc.util.UUIDIdentifier;

import java.util.Optional;

public interface UserRepository {
    User get(UUIDIdentifier identifier);

    Optional<User> getIfPresent(UUIDIdentifier identifier);

    void remove(UUIDIdentifier identifier);
}
