package me.conclure.model.user;

public class UserSnapshotImpl implements UserSnapshot {
    private final String username;

    public UserSnapshotImpl(String username) {
        this.username = username;
    }

    public String username() {
        return username;
    }

    @Override
    public UserSnapshot copy() {
        return new UserSnapshotImpl(username);
    }

    @Override
    public UserSnapshot username(String username) {
        return new UserSnapshotImpl(this.username);
    }
}
