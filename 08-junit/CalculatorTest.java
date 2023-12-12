package put.io.testing.junit;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator = null;
    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }

    @Test
    public void testAdd() {
        assertEquals(7, calculator.add(5,2));
    }

    @Test
    public void testMultiply() {
        assertEquals(10, calculator.multiply(5,2));
    }

    @Test
    public void testAddPositiveNumbers() {
        assertEquals(7, calculator.addPositiveNumbers(5, 2));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> assertEquals(8,calculator.addPositiveNumbers(9, -1)));
        assertEquals("The arguments must be positive", exception.getMessage());
    }
}