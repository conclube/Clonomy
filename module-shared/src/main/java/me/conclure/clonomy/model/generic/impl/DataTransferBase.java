package me.conclure.clonomy.model.generic.impl;

import me.conclure.clonomy.misc.util.Nil;
import me.conclure.clonomy.model.generic.DataTransfer;
import me.conclure.clonomy.model.generic.Snapshot;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
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

    private volatile S value;

    @Override
    public Nil<S> snapshot() {
        return Nil.optional(this.value);
    }

    @Override
    public void setSnapshot(S data) {
        this.value = data;
    }

    @Override
    public void clearSnapshot() {
        this.value = null;
    }

    @Override
    public void editSnapshot(Function<Nil<S>, Nil<S>> editor) {
        Nil<S> prev = this.snapshot();
        Nil<S> next = null;
        for (boolean haveNext = false;;) {
            if (!haveNext)
                next = editor.apply(prev);
            if (VALUE.weakCompareAndSet(this,prev.value(),next.value()))
                return;
            haveNext = (prev == (prev = this.snapshot()));
        }
    }
}
