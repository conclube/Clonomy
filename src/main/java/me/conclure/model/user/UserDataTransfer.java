package me.conclure.model.user;

import me.conclure.model.generic.GenericDataTransfer;

import java.util.UUID;

public interface UserDataTransfer extends GenericDataTransfer<UserSnapshot> {
    UUID id();
}
