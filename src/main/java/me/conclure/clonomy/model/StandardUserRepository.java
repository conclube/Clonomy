package me.conclure.clonomy.model;

import me.conclure.clonomy.misc.util.UUIDIdentifier;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class StandardUserRepository implements UserRepository {
    private final Map<UUIDIdentifier, WeakReference<User>> map;

    public StandardUserRepository() {
        this.map = new ConcurrentHashMap<>();
    }

    @Override
    public User get(UUIDIdentifier identifier) {
        //we need to do this to have a strong reference to user while potentially creating a new user if none exists
        //else we risk losing the user during creation
        var strongRef = new Object() {
            User user;
        };
        this.map.compute(identifier,(key,value) -> {
            if (value == null) return new WeakReference<>(strongRef.user = new StandardUser(key));
            if ((strongRef.user = value.get()) == null) return new WeakReference<>(strongRef.user = new StandardUser(key));
            return value;
        });
        return strongRef.user;
    }

    @Override
    public Optional<User> getIfPresent(UUIDIdentifier identifier) {
        var strongRef = new Object() {
            User user;
        };
        this.map.computeIfPresent(identifier,(key,value) -> {
            return (strongRef.user = value.get()) == null ? null : value;
        });
        return Optional.ofNullable(strongRef.user);
    }

    @Override
    public void remove(UUIDIdentifier identifier) {
        this.map.remove(identifier);
    }
}
