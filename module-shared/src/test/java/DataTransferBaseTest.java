import me.conclure.model.generic.impl.DataTransferBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Phaser;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataTransferBaseTest {
    @SuppressWarnings("rawtypes")
    DataTransferBase<MockSnapshot> dataTransferBase;

    @BeforeEach
    void setUp() {
        this.dataTransferBase = new DataTransferBase<>();
    }

    /*
    Tests the atomicity of DataTransferBase::editSnapshot
    by simulating a race condition with x amount of threads
    manipulating a shared variable from DataTransferBase.
     */
    @Test
    void testEditInMultipleThreads() {
        MockSnapshot<Integer> snapshot = new MockSnapshot<>(0);
        this.dataTransferBase.setSnapshot(snapshot);
        var threadAmount = 50;
        var countAmount = 200_000;
        var expectedTotalCountAmount = countAmount * threadAmount;

        Phaser phaser = new Phaser();
        phaser.bulkRegister(threadAmount);

        for (int i = 0; i < threadAmount; i++) {
            new Thread(() -> {
                phaser.arriveAndAwaitAdvance();
                for (int j = 0; j < countAmount; j++) {
                    this.dataTransferBase.editSnapshot(current -> {
                        final Integer integer = (Integer) current.object();
                        //noinspection unchecked
                        return current.object(integer + 1);
                    });
                }
                phaser.arrive();
            }).start();
        }

        phaser.awaitAdvance(0);
        phaser.awaitAdvance(1);

        assertEquals(this.dataTransferBase.snapshot().object(), expectedTotalCountAmount);
    }
}