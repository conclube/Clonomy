package me.conclure.clonomy.currency;

import me.conclure.clonomy.model.CurrencyHolder;
import me.conclure.clonomy.model.CurrencyHolderType;

public sealed interface Currency permits DecimalCurrency, IntegerCurrency {
    <R extends Number> R query(CurrencyQuery<R> query);

    boolean isSupported(CurrencyHolderType type);
}
