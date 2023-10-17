package me.conclure.clonomy.model;

import me.conclure.clonomy.misc.util.UUIDIdentifier;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

public class StandardUserRepository implements UserRepository {
    private final Map<UUIDIdentifier, Supplier<User>> map;

    public StandardUserRepository() {
        this.map = new ConcurrentHashMap<>();
    }

    @Override
    public User get(UUIDIdentifier identifier) {
        //we need to do this to have a strong reference to user while potentially creating a new user if none exists
        //else we risk losing the user during creation
        @SuppressWarnings("MismatchedReadAndWriteOfArray")
        User[] user = new User[1];
        return this.map.computeIfAbsent(identifier, key -> () -> new WeakReference<>(user[0] = new StandardUser(key)).get()).get();
    }
}
