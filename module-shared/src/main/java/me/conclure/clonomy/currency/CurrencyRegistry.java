package me.conclure.clonomy.currency;

public interface CurrencyRegistry {

    Object registerCurrency(Currency.Identifier identifier, Class<? extends T> type);

}
