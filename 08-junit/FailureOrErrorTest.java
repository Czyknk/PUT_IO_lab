package put.io.testing.junit;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class FailureOrErrorTest {
    @Test
    public void test1() {
        assertTrue(false);
    }

    @Test
    public void test2() {
        Throwable exception = assertThrows(NoSuchFieldException.class,
                () -> {
            throw new NoSuchFieldException("No Such Field");
        });
        assertEquals("No Such Field", exception.getMessage());
    }

    @Test
    public void test3() {
        try{
            assertTrue(false);
        }
        catch(Error e){
            e.printStackTrace();
        }
    }
}
