import me.conclure.model.generic.Snapshot;

public class MockSnapshot<O> implements Snapshot {
    private final O object;

    public MockSnapshot(O object) {
        this.object = object;
    }

    O object() {
        return this.object;
    }

    MockSnapshot<O> object(O o) {
        return new MockSnapshot<>(o);
    }

    @Override
    public MockSnapshot<O> copy() {
        return new MockSnapshot<>(this.object);
    }
}
