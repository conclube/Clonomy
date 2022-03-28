import me.conclure.clonomy.model.generic.Snapshot;

/*
This is a special mock, given that Snapshot is an "immutable builder"
the methods MockSnapshot::object will be used as a way to mock the pattern
that all the other implementations of Snapshot must follow.
 */
public class MockSnapshot<O> implements Snapshot {
    final O object;

    MockSnapshot(O object) {
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
