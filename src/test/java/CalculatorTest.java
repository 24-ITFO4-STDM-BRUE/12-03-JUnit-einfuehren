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
        assertEquals(6, calculator.divide(18, 3));
    }

    @Test
    public void testDivideBulkRand() {
        int a,b;
        double result;
        for (int i = 0; i < 100; i++) {
            a = (int)(1000 * (Math.random()));
            b = (int)(1000 * (Math.random() + 0.001));
            result = (double) a / b;
            assertEquals(result, calculator.divide(a, b));
        }
    }

    @Test
    public void testDivideZero() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> calculator.divide(1,0));
        assertEquals("Cannot divide by zero.", ex.getMessage());
    }
}