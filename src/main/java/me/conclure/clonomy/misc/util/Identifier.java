package me.conclure.clonomy.misc.util;

import java.util.UUID;

public sealed interface Identifier permits UUIDIdentifier, NamespaceIdentifier, NumberIdentifier {
    static UUIDIdentifier uuid(UUID uuid) {
        return null;
    }

}
