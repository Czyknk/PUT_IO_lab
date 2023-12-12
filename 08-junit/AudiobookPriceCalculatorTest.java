package put.io.testing.audiobooks;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class AudiobookPriceCalculatorTest {
    AudiobookPriceCalculator calculator = null;
    Audiobook audiobook = null;

    Customer customer1 = null;
    Customer customer2 = null;
    Customer customer3 = null;
    Customer customer4 = null;

    @BeforeEach
    public void setUp(){
        audiobook = new Audiobook("Koty",30.0);
        customer1 = new Customer("Leszek", Customer.LoyaltyLevel.GOLD,true);
        customer2 = new Customer("Krzysztof", Customer.LoyaltyLevel.SILVER,false);
        customer3 = new Customer("Alicja", Customer.LoyaltyLevel.GOLD,false);
        customer4 = new Customer("Aleks", Customer.LoyaltyLevel.STANDARD,false);

        calculator = new AudiobookPriceCalculator();
    }

    @Test
    public void test1(){
        assertEquals(0.0, calculator.calculate(customer1,audiobook));
    }
    @Test
    public void test2(){
        assertEquals(27.0, calculator.calculate(customer2,audiobook));
    }
    @Test
    public void test3(){
        assertEquals(24.0, calculator.calculate(customer3,audiobook));
    }
    @Test
    public void test4(){
        assertEquals(30.0, calculator.calculate(customer4,audiobook));
    }
}
