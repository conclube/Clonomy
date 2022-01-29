package me.conclure.model.user;

import me.conclure.annotation.AlwaysNew;
import me.conclure.model.generic.Snapshot;

public interface UserSnapshot extends Snapshot {

    static UserSnapshot create(String username) {
        return new UserSnapshotImpl(username);
    }

    static UserSnapshot create() {
        return UserSnapshot.create(null);
    }

    @Override
    UserSnapshot copy();

    String username();

    @AlwaysNew
    UserSnapshot username(String username);
}