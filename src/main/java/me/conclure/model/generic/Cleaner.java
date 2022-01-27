package me.conclure.model.generic;

import me.conclure.annotation.NonNull;
import me.conclure.annotation.ThreadSafe;

@ThreadSafe
@NonNull
public interface Cleaner<I> {
    void registerFresh(I id);

    void keep(I id);

    void unkeep(I id);

    void attemptClean(I id);

    void performCleanUp();
}
