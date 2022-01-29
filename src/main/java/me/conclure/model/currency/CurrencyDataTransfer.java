package me.conclure.model.currency;

import me.conclure.model.generic.DataTransfer;

public interface CurrencyDataTransfer<N extends Number> extends DataTransfer<CurrencySnapshot> {
    Class<N> numberType();
}
