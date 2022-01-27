package me.conclure.model.user;

import me.conclure.model.generic.Snapshot;

public interface UserSnapshot extends Snapshot<UserSnapshot> {

    UserSnapshot username(String username);
}
