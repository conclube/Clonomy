package me.conclure.clonomy.currency;

import me.conclure.clonomy.model.CurrencyHolderType;

public non-sealed class IntegerCurrency implements Currency {
    @Override
    public <R extends Number> R query(CurrencyQuery<R> query) {
        return null;
    }

    @Override
    public boolean isSupported(CurrencyHolderType type) {
        return false;
    }
}
