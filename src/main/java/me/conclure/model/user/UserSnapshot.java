package me.conclure.model.user;

import me.conclure.annotation.AlwaysNew;
import me.conclure.model.currency.Currency;
import me.conclure.model.generic.Snapshot;

import java.util.IdentityHashMap;

public interface UserSnapshot extends Snapshot {

    static UserSnapshot create(String username) {
        return new UserSnapshotImpl(username,new IdentityHashMap<>());
    }

    static UserSnapshot create() {
        return UserSnapshot.create(null);
    }

    @Override
    UserSnapshot copy();

    String username();

    @AlwaysNew
    UserSnapshot username(String username);

    <N extends Number> N balance(Currency<N> currency);

    @AlwaysNew
    <N extends Number> UserSnapshot balance(Currency<N> currency, N newBalance);
}