package me.conclure.clonomy.model.storage.service;

import me.conclure.clonomy.model.User;

public interface Storage {
    void save(User user);

    void load(User user);
}
