package me.conclure.clonomy.misc.util;

public final class SneakyThrower {
    public static <T extends Throwable> void sneakyThrow(Throwable t) throws T {
        throw (T) t;
    }
}
