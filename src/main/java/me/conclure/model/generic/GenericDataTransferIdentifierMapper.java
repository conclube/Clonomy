package me.conclure.model.generic;

public interface GenericDataTransferIdentifierMapper<I,T extends GenericDataTransfer<S>,S extends GenericSnapshot<S>> {
    I identifierFrom(T transfer);
}
