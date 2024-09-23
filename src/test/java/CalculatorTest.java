import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.time.Duration;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @BeforeEach
    void setUp() {
        Calculator calculator = new Calculator();
    }

    @AfterEach
    void doneWithIt() {
        System.out.println("Test abgeschlossen ♥");
    }

    @Test
    public void testAdd() {
        assertEquals(5, calculator.add(2, 3), "2 + 3 sollte 5 ergeben");
    }

    @Test
    public void testSubtract() {
        assertEquals(1, calculator.subtract(5, 4), "5 - 4 sollte 1 ergeben");
    }

    @Test
    public void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3), "2 * 3 sollte 6 ergeben");
    }
    @Test
    public void testDivide() { assertEquals( 3, calculator.divide(9,3), "9 / 3 sollte 3 ergeben");}

    @Test
    public void testDivideByZero() {
        assertThrows(IllegalArgumentException.class,
                ()-> {
                    calculator.divide(9,0);
                });
    }

    @Test
    public void testGreaterDividedBySmaller() {
        assertEquals(0.5, calculator.divide(5,10),"5 / 10 sollte 0.5 ergeben");
    }

    @Test
    public void testFibonacciArrayBiggerZero() {assertTrue(calculator.generateFibonacci(5).length > 0,"muss gleich sein");}

    @Test
    public void testFibonacciArrayIsZero() {assertTrue(calculator.generateFibonacci(0).length == 0,"muss gleich sein");}

    @Test
    public void testFibonacciFirstEntries() {assertTrue(calculator.generateFibonacci(50)[0] == 0 && calculator.generateFibonacci(50)[1] == 1,"muss gleich sein");}


    @Test
    public void testFibonacciCorrectArray() {assertArrayEquals(new int[]{0,1,1,2,3},calculator.generateFibonacci(5),"Array muss so aussehen");}

    @Test
    public void testFibonacciTestDuration() {assertTimeout(Duration.ofSeconds(1),() -> {
        calculator.generateFibonacci(40);});}

}

