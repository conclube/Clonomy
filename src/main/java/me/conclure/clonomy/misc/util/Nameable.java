package me.conclure.clonomy.misc.util;

import net.kyori.adventure.text.Component;

public interface Nameable {
    String name();

    default Component nameAsComponent() {
        return Component.text(this.name());
    }
}
