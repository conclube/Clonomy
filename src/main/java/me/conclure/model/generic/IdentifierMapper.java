package me.conclure.model.generic;

import me.conclure.annotation.NonNull;
import me.conclure.annotation.ThreadSafe;

@ThreadSafe
@NonNull
public interface IdentifierMapper<I, T extends DataTransfer<?>> {
    I identifierFrom(T transfer);
}
