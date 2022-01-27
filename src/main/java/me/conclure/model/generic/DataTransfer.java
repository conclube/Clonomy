package me.conclure.model.generic;

import me.conclure.annotation.NonNull;
import me.conclure.annotation.Nullable;
import me.conclure.annotation.ThreadSafe;

import java.util.function.Function;

@ThreadSafe
@NonNull
public interface DataTransfer<S extends Snapshot<S>> {
    @Nullable
    S snapshot();

    void setSnapshot(@Nullable S data);

    default void editData(Function<@Nullable? super S,@Nullable? extends S> editor) {
        this.setSnapshot(editor.apply(this.snapshot()));
    }
}
