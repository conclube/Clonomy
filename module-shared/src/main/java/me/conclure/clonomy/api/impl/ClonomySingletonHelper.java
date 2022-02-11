package me.conclure.clonomy.api.impl;

import me.conclure.clonomy.api.Clonomy;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Optional;

public final class ClonomySingletonHelper {
    static final Field singletonField;

    static {
        try {
            singletonField = Clonomy.class.getDeclaredField("instance");
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void set(Clonomy service) {
        if (ClonomySingletonHelper.get().isEmpty()) {
            try {
                singletonField.set(null,service);
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException(e);
            }
            return;
        }
        throw new IllegalStateException("Service was already set");
    }

    public static void clear() {
        try {
            singletonField.set(null,null);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    public static Optional<Clonomy> get() {
        try {
            return Optional.ofNullable((Clonomy)singletonField.get(null));
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }
}
