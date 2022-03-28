package me.conclure.clonomy.model.bank;

import me.conclure.clonomy.model.generic.Snapshot;

public interface BankAccountSnapshot<N extends Number> extends Snapshot {

    BankAccountSnapshot<N> balance(N newBalance);

    N balance();

    @Override
    BankAccountSnapshot<N> copy();
}