package me.conclure.clonomy.model;

import me.conclure.clonomy.currency.Currency;

public interface CurrencyHolderType {
    boolean isSupportedBy(Currency currency);
}
