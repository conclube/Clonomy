package me.conclure.clonomy.model;

public interface CurrencyHolderSelector {
    boolean isSupported(CurrencyHolderType type);

    SelectableCurrencyHolder select(CurrencyHolder holder);

}
