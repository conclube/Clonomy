package me.conclure.model.user;

import me.conclure.model.currency.Currency;

import java.util.IdentityHashMap;
import java.util.Map;

public class UserSnapshotImpl implements UserSnapshot {
    private final String username;
    private final Map<Currency<?>, Number> currencyMap;

    UserSnapshotImpl(String username, Map<Currency<?>, Number> currencyMap) {
        this.username = username;
        this.currencyMap = currencyMap;
    }

    @Override
    public UserSnapshot copy() {
        return new UserSnapshotImpl(this.username, this.currencyMap);
    }

    @Override
    public String username() {
        return this.username;
    }

    @Override
    public UserSnapshot username(String username) {
        return new UserSnapshotImpl(username, this.currencyMap);
    }

    @Override
    public <N extends Number> N balance(Currency<N> currency) {
        return (N) this.currencyMap.get(currency);
    }

    @Override
    public <N extends Number> UserSnapshot balance(Currency<N> currency, N newBalance) {
        Map<Currency<?>, Number> currencyMap = new IdentityHashMap<>(this.currencyMap);
        currencyMap.put(currency, newBalance);
        return new UserSnapshotImpl(this.username, currencyMap);
    }
}
