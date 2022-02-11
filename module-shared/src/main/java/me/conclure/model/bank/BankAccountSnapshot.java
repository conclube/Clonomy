package me.conclure.model.bank;

import me.conclure.model.generic.Snapshot;

public interface BankAccountSnapshot<N extends Number> extends Snapshot {

    BankAccountSnapshot<N> balance(N newBalance);

    N balance();

    @Override
    BankAccountSnapshot<N> copy();
}