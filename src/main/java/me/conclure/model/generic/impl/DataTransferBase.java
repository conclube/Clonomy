package me.conclure.model.generic.impl;

import me.conclure.model.generic.DataTransfer;
import me.conclure.model.generic.Snapshot;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;

public class DataTransferBase<S extends Snapshot> implements DataTransfer<S> {
    private static final VarHandle VALUE;

    static {
        try {
            MethodHandles.Lookup l = MethodHandles.lookup();
            VALUE = l.findVarHandle(DataTransferBase.class, "value", Snapshot.class);
        } catch (ReflectiveOperationException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    @SuppressWarnings("unused")
    private volatile Snapshot value;

    @SuppressWarnings("unchecked")
    @Override
    public S snapshot() {
        return (S) this.value;
    }

    @Override
    public void setSnapshot(S data) {
        this.value = data;
    }

    @Override
    public void editSnapshot(Function<? super S, ? extends S> editor) {
        S prev = this.snapshot(), next = null;
        for (boolean haveNext = false;;) {
            if (!haveNext)
                next = editor.apply(prev);
            if (VALUE.weakCompareAndSet(this,prev,next))
                return;
            haveNext = (prev == (prev = this.snapshot()));
        }
    }
}
