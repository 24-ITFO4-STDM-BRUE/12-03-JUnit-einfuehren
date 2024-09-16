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
    public  void testDivide() {
        assertEquals(6, calculator.divide(18, 3), "18 / 3 sollte 6 ergeben");
    }

    @Test
    public void testZero() {
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(18, 0), "Geht einfach nicht, wieso?");

    }
    @Test
    public void testMessage() {
        IllegalArgumentException exception =
        assertThrowsExactly(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("Cannot divide by zero.");
        });
        assertEquals("Cannot divide by zero.", exception.getMessage());
    }
}