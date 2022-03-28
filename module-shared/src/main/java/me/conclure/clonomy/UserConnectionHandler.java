package me.conclure.clonomy;

import me.conclure.clonomy.model.user.UserDataTransfer;
import me.conclure.clonomy.model.user.UserManagerInterface;

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