package me.conclure.model.generic.impl;

import me.conclure.model.generic.GenericSnapshot;
import me.conclure.model.generic.GenericDataTransfer;

public class DataTransferBase<S extends GenericSnapshot<S>> implements GenericDataTransfer<S> {
    private volatile S data;

    @Override
    public S snapshotData() {
        return this.data;
    }

    @Override
    public void setData(S data) {
        this.data = data;
    }
}
