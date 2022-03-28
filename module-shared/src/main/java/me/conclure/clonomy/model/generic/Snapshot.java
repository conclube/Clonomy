package me.conclure.clonomy.model.generic;

import me.conclure.clonomy.annotations.AlwaysNew;
import me.conclure.clonomy.annotations.Immutable;
import me.conclure.clonomy.annotations.ThreadSafe;

@Immutable
public interface Snapshot {
    @ThreadSafe
    @AlwaysNew
    Snapshot copy();
}
