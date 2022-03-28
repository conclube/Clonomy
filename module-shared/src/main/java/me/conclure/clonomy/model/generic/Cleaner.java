
package me.conclure.clonomy.model.generic;

import me.conclure.clonomy.annotations.NonNull;
import me.conclure.clonomy.annotations.ThreadSafe;

@ThreadSafe
public interface Cleaner<I> {
    void registerAsFresh(I id);

    void keep(I id);

    void unkeep(I id);

    void attemptClean(I id);

    void performCleanUpForAll();
}
