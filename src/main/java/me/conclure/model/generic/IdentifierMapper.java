package me.conclure.model.generic;

public interface IdentifierMapper<I,T extends DataTransfer<S>,S extends Snapshot<S>> {
    I identifierFrom(T transfer);
}
