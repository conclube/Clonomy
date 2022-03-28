package me.conclure.clonomy.model.bank;

import me.conclure.clonomy.model.generic.DataTransfer;

import java.util.UUID;

public interface BankAccountDataTransfer<N extends Number> extends DataTransfer<BankAccountSnapshot<N>> {

    UUID getOwnerId();
}
