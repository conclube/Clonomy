package me.conclure;

import java.util.Collection;
import java.util.UUID;
import java.util.function.Function;

public interface UserRepository extends Iterable<UserDataTransfer> {

    static UserRepository create() {
        return new UserRepositoryImpl();
    }

    UserDataTransfer getOrCreate(UUID id);

    boolean invalidate(UUID id);

    Collection<? extends UserDataTransfer> getAll();

    <R> Collection<? extends R> applyAndGetAll(Function<?super UserDataTransfer,?extends R> transformer);
}