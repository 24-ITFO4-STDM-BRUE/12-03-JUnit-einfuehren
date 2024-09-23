import com.sun.tools.javac.Main;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void testNotNull() {
        int n = 5;
        int[] result = calculator.generateFibonacci(n);
        assertNotNull(result, "Das Ergebnis sollte nicht null sein.");}

    @Test
    public void testGenerateFibonacciEmptyArrayForZero() {
        int n = 0;
        int[] result = calculator.generateFibonacci(n);
        assertEquals(0, result.length, "Das Ergebnis sollte ein leeres Array sein, wenn n gleich 0 ist.");
    }

}