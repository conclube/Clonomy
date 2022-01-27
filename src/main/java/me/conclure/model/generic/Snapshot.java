package me.conclure.model.generic;

import me.conclure.annotation.NonNull;
import me.conclure.annotation.ThreadSafe;

@ThreadSafe
@NonNull
public interface Snapshot<S extends Snapshot<S>> {
    S copy();
}
