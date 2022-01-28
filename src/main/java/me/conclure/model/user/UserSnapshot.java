package me.conclure.model.user;

import me.conclure.model.currency.Currency;
import me.conclure.model.generic.Snapshot;

import java.util.IdentityHashMap;

public interface UserSnapshot extends Snapshot<UserSnapshot> {

    static UserSnapshot create(String username) {
        return new UserSnapshotImpl(username,new IdentityHashMap<>());
    }

    static UserSnapshot create() {
        return UserSnapshot.create(null);
    }

    String username();

    UserSnapshot username(String username);

    <N extends Number> N balance(Currency<N> currency);

    <N extends Number> UserSnapshot balance(Currency<N> currency, N newBalance);
}