package me.conclure.clonomy.model.storage.child;

import me.conclure.clonomy.model.User;

public class UserUpdateListener {
    private final ChildUserStorage userStorage;

    public UserUpdateListener(ChildUserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public void onUpdate(User user) {
        this.userStorage.load(user);
    }
}
