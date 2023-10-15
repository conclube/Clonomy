package me.conclure.clonomy.currency;

public interface CurrencyQuery<R extends Number> {
    R queryFrom(Currency currency);
}
