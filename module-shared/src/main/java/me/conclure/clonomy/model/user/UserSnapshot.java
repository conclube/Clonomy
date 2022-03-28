package me.conclure.clonomy.model.user;

import me.conclure.clonomy.annotations.AlwaysNew;
import me.conclure.clonomy.misc.util.Nil;
import me.conclure.clonomy.model.generic.Snapshot;

public interface UserSnapshot extends Snapshot {

    static UserSnapshot create(String username) {
        return new UserSnapshotImpl(username);
    }

    static UserSnapshot create() {
        return UserSnapshot.create(null);
    }

    @Override
    UserSnapshot copy();

    Nil<String> username();

    @AlwaysNew
    UserSnapshot username(Nil<String> username);
}