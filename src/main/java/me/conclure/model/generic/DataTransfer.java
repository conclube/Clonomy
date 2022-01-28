package me.conclure.model.generic;

import me.conclure.annotation.NonNull;
import me.conclure.annotation.Nullable;
import me.conclure.annotation.ThreadSafe;

import java.util.function.Function;

@ThreadSafe
@NonNull
public interface DataTransfer<S extends Snapshot> {
    @Nullable
    S snapshot();

    void setSnapshot(@Nullable S data);

    void editSnapshot(Function<@Nullable ? super S, @Nullable ? extends S> editor);
}
