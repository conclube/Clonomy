package me.conclure.model.user;

import me.conclure.model.generic.DataTransfer;

import java.util.UUID;

public interface UserDataTransfer extends DataTransfer<UserSnapshot> {
    UUID id();
}
