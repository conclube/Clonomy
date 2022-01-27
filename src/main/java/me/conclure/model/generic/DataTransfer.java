package me.conclure.model.generic;

import java.util.function.Function;

public interface DataTransfer<S extends Snapshot<S>> {
    S snapshot();

    void setSnapshot(S data);

    default void editData(Function<? super S, ? extends S> editor) {
        this.setSnapshot(editor.apply(this.snapshot()));
    }
}
