package me.conclure.clonomy.model.user;

import me.conclure.clonomy.model.generic.DataTransfer;

import java.util.UUID;

public interface UserDataTransfer extends DataTransfer<UserSnapshot> {
    UUID id();

    boolean isOnline();
}
