package me.conclure.clonomy.model;

import me.conclure.clonomy.currency.Currency;
import me.conclure.clonomy.misc.util.Identifier;
import me.conclure.clonomy.misc.util.Nameable;
import me.conclure.clonomy.misc.util.UUIDIdentifier;

public interface User extends CurrencyHolder, LifetimeOwnable, Nameable {
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
