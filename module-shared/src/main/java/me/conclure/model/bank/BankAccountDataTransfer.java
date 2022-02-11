package me.conclure.model.bank;

import me.conclure.model.generic.DataTransfer;
import me.conclure.model.user.UserDataTransfer;

import java.util.UUID;

public interface BankAccountDataTransfer<N extends Number> extends DataTransfer<BankAccountSnapshot<N>> {

    UUID getOwnerId();
}
