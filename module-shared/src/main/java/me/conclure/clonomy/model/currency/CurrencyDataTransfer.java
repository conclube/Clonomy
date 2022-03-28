package me.conclure.clonomy.model.currency;

import me.conclure.clonomy.model.generic.DataTransfer;

public interface CurrencyDataTransfer<N extends Number> extends DataTransfer<CurrencySnapshot> {
    Class<N> numberType();
}
