package me.conclure.clonomy.model.generic;

import me.conclure.clonomy.annotations.NonNull;
import me.conclure.clonomy.annotations.ThreadSafe;

@ThreadSafe
public interface IdentifierMapper<I, T extends DataTransfer<?>> {
    I identifierFrom(T transfer);
}
