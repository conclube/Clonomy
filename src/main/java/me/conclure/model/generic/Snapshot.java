package me.conclure.model.generic;

import me.conclure.annotation.AlwaysNew;
import me.conclure.annotation.NonNull;
import me.conclure.annotation.ThreadSafe;

@ThreadSafe
@NonNull
public interface Snapshot {
    @AlwaysNew
    Snapshot copy();
}
