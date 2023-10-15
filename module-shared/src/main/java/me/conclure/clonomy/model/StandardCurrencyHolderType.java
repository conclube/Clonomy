package me.conclure.clonomy.model;

import me.conclure.clonomy.currency.Currency;

public enum StandardCurrencyHolderType implements CurrencyHolderType {
    USER,
    BANK,
    ACCOUNT;

    @Override
    public boolean isSupportedBy(Currency currency) {
        return currency.isSupported(this);
    }
}
