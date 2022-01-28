package me.conclure.model.generic.impl;

import me.conclure.model.generic.DataTransfer;
import me.conclure.model.generic.Snapshot;

public class DataTransferBase<S extends Snapshot<S>> implements DataTransfer<S> {
    private volatile S data;

    @Override
    public S snapshot() {
        return this.data;
    }

    @Override
    public void setSnapshot(S data) {
        this.data = data;
    }
}
