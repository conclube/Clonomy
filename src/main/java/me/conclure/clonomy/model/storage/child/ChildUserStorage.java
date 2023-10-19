package me.conclure.clonomy.model.storage.child;

import me.conclure.clonomy.model.User;

public interface ChildUserStorage {
    void load(User user);

    void save(User user);
}
