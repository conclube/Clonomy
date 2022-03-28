package me.conclure.clonomy.model.bank.impl;

import me.conclure.clonomy.model.generic.impl.DataTransferBase;
import me.conclure.clonomy.model.bank.BankAccountDataTransfer;
import me.conclure.clonomy.model.bank.BankAccountSnapshot;

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
