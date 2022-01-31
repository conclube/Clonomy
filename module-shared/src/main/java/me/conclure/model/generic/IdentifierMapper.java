package me.conclure.model.generic;

import me.conclure.clonomy.annotations.NonNull;
import me.conclure.clonomy.annotations.ThreadSafe;

@ThreadSafe
@NonNull
public interface IdentifierMapper<I, T extends DataTransfer<?>> {
    I identifierFrom(T transfer);
}
