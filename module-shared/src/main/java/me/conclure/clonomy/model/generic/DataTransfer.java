package me.conclure.clonomy.model.generic;

import me.conclure.clonomy.annotations.ThreadSafe;
import me.conclure.clonomy.misc.util.Nil;

import java.util.function.Function;

@ThreadSafe
public interface DataTransfer<S extends Snapshot> {
    Nil<S> snapshot();

    void setSnapshot(S data);

    void clearSnapshot();

    void editSnapshot(Function<Nil<S>, Nil<S>> editor);
}
