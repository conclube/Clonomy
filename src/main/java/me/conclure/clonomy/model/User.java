package me.conclure.clonomy.model;

import me.conclure.clonomy.currency.Currency;
import me.conclure.clonomy.misc.util.Nameable;
import me.conclure.clonomy.misc.util.UUIDIdentifier;

import java.util.concurrent.locks.ReadWriteLock;

public interface User extends CurrencyHolder, Nameable, Identifiable, ReadWriteLock {
    @Override
    UUIDIdentifier id();

    @Override
    default CurrencyHolderType type() {
        return StandardCurrencyHolderType.USER;
    }

    @Override
    default boolean isSupportedBy(Currency currency) {
        return currency.isSupported(this.type());
    }

}
