package me.conclure.clonomy.currency;

public enum NumberField implements CurrencyField {
    FRACTIONAL_PART_OF_NUMBER,
    INTEGER_PART_OF_NUMBER;

    @Override
    public long getFrom(Currency currency) {
        return 0;
    }
}
