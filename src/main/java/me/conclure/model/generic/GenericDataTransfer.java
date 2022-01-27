package me.conclure.model.generic;

import java.util.function.Function;

public interface GenericDataTransfer<S extends GenericSnapshot<S>> {
    S snapshotData();

    void setData(S data);

    default void editData(Function<? super S, ? extends S> editor) {
        this.setData(editor.apply(this.snapshotData()));
    }
}
