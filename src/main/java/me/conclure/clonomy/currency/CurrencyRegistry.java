package me.conclure.clonomy.currency;

import me.conclure.clonomy.misc.util.Identifier;

public interface CurrencyRegistry {

    Object registerCurrency(Identifier identifier, Currency currency);

}
