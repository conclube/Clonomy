package me.conclure.model.user;

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
    public String username() {
        return this.username;
    }

    @Override
    public UserSnapshot username(String username) {
        return new UserSnapshotImpl(username);
    }
}
