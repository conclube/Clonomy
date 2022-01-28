package me.conclure.model.currency;

import me.conclure.annotation.IdentityHolder;

@IdentityHolder
public interface Currency<N extends Number> {
    Class<N> numberType();
}
