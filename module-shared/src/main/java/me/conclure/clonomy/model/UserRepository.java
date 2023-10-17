package me.conclure.clonomy.model;

import me.conclure.clonomy.misc.util.UUIDIdentifier;

public interface UserRepository {
    User get(UUIDIdentifier identifier);


}
