package me.conclure.model.user;

import me.conclure.model.generic.impl.DataTransferBase;

import java.util.UUID;

public class UserDataTransferImpl extends DataTransferBase<UserSnapshot> implements UserDataTransfer {
    private final UUID id;

    public UserDataTransferImpl(UUID id) {
        this.id = id;
    }

    @Override
    public UUID id() {
        return this.id;
    }
}
