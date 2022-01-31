import me.conclure.clonomy.api.Clonomy;
import me.conclure.clonomy.api.impl.ClonomyBringerHelper;
import me.conclure.clonomy.api.impl.ClonomyBringerHelperImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class ClonomyBringerHelperImplTest {
    ClonomyBringerHelper clonomyBringerHelper;

    @BeforeEach
    void setUp() {
        clonomyBringerHelper = new ClonomyBringerHelperImpl();
    }

    @Test
    void testIsBringEmptyAfterInstantiation() {
        assertTrue(clonomyBringerHelper.bring().isEmpty());
    }

    @Test
    void testIsBringPresentAfterSet() {
        Clonomy clonomyMock = mock(Clonomy.class);
        clonomyBringerHelper.set(clonomyMock);
        assertTrue(clonomyBringerHelper.bring().isPresent());
    }

    @Test
    void testIsBringEmptyAfterAbort() {
        clonomyBringerHelper.abort();
        assertTrue(clonomyBringerHelper.bring().isEmpty());
    }
}
