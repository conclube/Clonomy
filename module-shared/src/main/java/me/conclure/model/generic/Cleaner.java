
package me.conclure.model.generic;

import me.conclure.clonomy.annotations.NonNull;
import me.conclure.clonomy.annotations.ThreadSafe;

@ThreadSafe
@NonNull
public interface Cleaner<I> {
    void registerAsFresh(I id);

    void keep(I id);

    void unkeep(I id);

    void attemptClean(I id);

    void performCleanUpForAll();
}
