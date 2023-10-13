package me.conclure.clonomy.currency;

public sealed interface Currency permits IntegerCurrency, DecimalCurrency {

    interface Identifier {

    }

}
