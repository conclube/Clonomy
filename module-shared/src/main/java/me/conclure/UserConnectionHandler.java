package me.conclure;

import me.conclure.model.user.UserDataTransfer;
import me.conclure.model.user.UserManagerInterface;

import java.util.UUID;

public class UserConnectionHandler {
    private final UserManagerInterface userManagerInterface;

    public UserConnectionHandler(UserManagerInterface userManagerInterface) {
        this.userManagerInterface = userManagerInterface;
    }

    public void registerInitialization(UUID id) {
        UserDataTransfer transfer = this.userManagerInterface.loadAndGet(id);
    }

    public void registerTermination(UUID id) {

    }
}