package me.conclure.clonomy.model;

import me.conclure.clonomy.currency.Currency;

public interface CurrencyHolder {
    CurrencyHolderType type();

    boolean isSupportedBy(Currency currency);



}
