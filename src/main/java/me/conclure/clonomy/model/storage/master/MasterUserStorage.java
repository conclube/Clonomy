package me.conclure.clonomy.model.storage.master;

import me.conclure.clonomy.model.User;

public interface MasterUserStorage {

    void loadPersistently(User user);

    void savePersistently(User user);

    void loadTransiently(User user);

    void saveTransiently(User user);

    void load(User user);

    void save(User user);
}
