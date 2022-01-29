package me.conclure.model.generic;

import me.conclure.annotation.AlwaysNew;
import me.conclure.annotation.Immutable;
import me.conclure.annotation.ThreadSafe;

@Immutable
public interface Snapshot {
    @ThreadSafe
    @AlwaysNew
    Snapshot copy();
}
