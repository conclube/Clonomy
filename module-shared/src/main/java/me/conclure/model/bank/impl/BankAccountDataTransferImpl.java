package me.conclure.model.bank.impl;

import me.conclure.model.bank.BankAccountDataTransfer;
import me.conclure.model.bank.BankAccountSnapshot;
import me.conclure.model.generic.impl.DataTransferBase;

import java.util.UUID;

public class BankAccountDataTransferImpl<N extends Number> extends DataTransferBase<BankAccountSnapshot<N>> implements BankAccountDataTransfer<N> {
    private final UUID id;

    public BankAccountDataTransferImpl(UUID id) {
        this.id = id;
    }

    @Override
    public UUID getOwnerId() {
        return this.id;
    }
}
