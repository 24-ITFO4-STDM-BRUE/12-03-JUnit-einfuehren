import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

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
    public void testDivide() {
        assertEquals(2, calculator.divide(4, 2));
    }

    @Test
    public void testDivideByZero() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });
    }

    @Test
    public void testFibonacci() {
        assertEquals((new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21}),calculator.generateFibonacci(10));
    }

    @Test
    public void  testFibonacciFirstTwoValues() {

        int[] result = calculator.generateFibonacci(10);

        assertEquals(0, result[0]);
        assertEquals(1, result[1]);
    }

    @Test
    public void testFibonacciNull() {
        assertEquals(new  int[]{}, calculator.generateFibonacci(0));
    }

    @Test
    public void testPower() {
        assertEquals(8, calculator.power(2, 3));
        assertEquals(1, calculator.power(5, 0));
    }

}

