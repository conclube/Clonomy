import me.conclure.clonomy.misc.util.Nil;
import me.conclure.clonomy.model.generic.impl.DataTransferBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.concurrent.Phaser;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataTransferBaseTest {
    DataTransferBase<MockSnapshot<Integer>> dataTransferBase;

    @BeforeEach
    void setUp() {
        this.dataTransferBase = new DataTransferBase<>();
    }

    /*
    Tests the atomicity of DataTransferBase::editSnapshot
    by attempting to simulate a race condition with x amount of threads
    that manipulate a shared variable from DataTransferBase.
     */
    @RepeatedTest(10)
    void testEditInMultipleThreads() {
        MockSnapshot<Integer> snapshot = new MockSnapshot<>(0);
        this.dataTransferBase.setSnapshot(snapshot);
        var threadAmount = 1_000;
        var countAmount = 10_000;
        var expectedTotalCountAmount = countAmount * threadAmount;

        Phaser phaser = new Phaser();
        phaser.bulkRegister(threadAmount);

        for (int i = 0; i < threadAmount; i++) {
            new Thread(() -> {
                phaser.arriveAndAwaitAdvance();
                for (int j = 0; j < countAmount; j++) {
                    this.dataTransferBase.editSnapshot(current -> current
                            .map(theSnapshot -> theSnapshot.object(theSnapshot.object+1))
                    );
                }
                phaser.arrive();
            }).start();
        }

        phaser.awaitAdvance(0);
        phaser.awaitAdvance(1);

        assertEquals(this.dataTransferBase.snapshot().map(MockSnapshot::object).value(), expectedTotalCountAmount);
    }
}