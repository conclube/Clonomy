package me.conclure.clonomy.model.user;

import me.conclure.clonomy.misc.util.Nil;

public class UserSnapshotImpl implements UserSnapshot {
    private final String username;

    UserSnapshotImpl(String username) {
        this.username = username;
    }

    @Override
    public UserSnapshot copy() {
        return new UserSnapshotImpl(this.username);
    }

    @Override
    public Nil<String> username() {
        return Nil.optional(this.username);
    }

    @Override
    public UserSnapshot username(Nil<String> username) {
        return new UserSnapshotImpl(username.value());
    }
}
