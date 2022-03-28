package me.conclure.clonomy.model.bank.impl;

import me.conclure.clonomy.model.bank.BankAccountSnapshot;

public class BankAccountSnapshotImpl<N extends Number> implements BankAccountSnapshot<N> {
    private final N balance;

    public BankAccountSnapshotImpl(N balance) {
        this.balance = balance;
    }

    @Override
    public BankAccountSnapshot<N> balance(N newBalance) {
        return new BankAccountSnapshotImpl<>(newBalance);
    }

    @Override
    public N balance() {
        return this.balance;
    }

    @Override
    public BankAccountSnapshot<N> copy() {
        return new BankAccountSnapshotImpl<>(this.balance);
    }
}
