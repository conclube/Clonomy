package me.conclure;

import me.conclure.annotation.NonNull;
import me.conclure.annotation.Nullable;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public interface DataTransferHolder<S extends DataSnapshot> {
    S snapshotData();

    void setData(S data);

    default void editData(Function<? super S, ? extends S> editor) {
        this.setData(editor.apply(this.snapshotData()));
    }
}
