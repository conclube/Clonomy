package me.conclure.clonomy.currency;

public sealed interface Currency permits DecimalCurrency, IntegerCurrency {
    <R extends Number> R query(CurrencyQuery<R> query);
}
