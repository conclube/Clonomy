import me.conclure.model.generic.Snapshot;
import me.conclure.model.generic.impl.DataTransferBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;

import static org.junit.jupiter.api.Assertions.*;

public class DataTransferBaseTest {
    @SuppressWarnings("rawtypes")
    DataTransferBase<MockSnapshot> dataTransferBase;

    @BeforeEach
    void setUp() {
        dataTransferBase = new DataTransferBase<>();
    }

    @Test
    void testNullableSnapshotAfterCreation() {
        assertNull(dataTransferBase.snapshot());
    }

    @Test
    void testSetAndGet() {
        MockSnapshot<?> snapshot = new MockSnapshot<>(null);
        dataTransferBase.setSnapshot(snapshot);
        assertSame(snapshot,dataTransferBase.snapshot());
    }

    @Test
    void testEdit() {
        var ref = new Object() {
            MockSnapshot<?> snapshot = new MockSnapshot<>(null);
        };

        dataTransferBase.setSnapshot(ref.snapshot);
        dataTransferBase.editSnapshot(current -> {
            assertSame(ref.snapshot, current);

            ref.snapshot = ref.snapshot.copy();
            return ref.snapshot;
        });

        assertSame(ref.snapshot,dataTransferBase.snapshot());
    }

    @Test
    void testEditInMultipleThreads() {
        MockSnapshot<Integer> snapshot = new MockSnapshot<>(0);
        dataTransferBase.setSnapshot(snapshot);
        var threadAmount = 100;
        var countAmount = 100_000;
        var expectedTotalCountAmount = countAmount*threadAmount;

        CountDownLatch startRaceLatch = new CountDownLatch(1);
        CountDownLatch finishRaceLatch = new CountDownLatch(threadAmount);

        for (int i = 0; i < threadAmount; i++) {
            new Thread(() -> {
                try {
                    startRaceLatch.await();
                } catch (InterruptedException e) {
                    fail(e);
                }
                for (int j = 0; j < countAmount; j++) {
                    dataTransferBase.editSnapshot(current -> {
                        final Integer integer = (Integer) current.object();
                        //noinspection unchecked
                        return current.object(integer + 1);
                    });
                }
                finishRaceLatch.countDown();
            }).start();
        }

        startRaceLatch.countDown();

        try {
            finishRaceLatch.await();
        } catch (InterruptedException e) {
            fail(e);
        }

        assertEquals(dataTransferBase.snapshot().object(),expectedTotalCountAmount);
    }
}