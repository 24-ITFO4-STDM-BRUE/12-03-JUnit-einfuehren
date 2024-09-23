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
        assertEquals(3, calculator.divide(6, 2), "6 / 2 sollte 3 ergeben");

    }
    @Test
    public void testGenerateFibonacci_NotNullForPositiveN() {
        int[] result = calculator.generateFibonacci(5); // Aufruf der Methode über die Instanz
        assertNotNull(result);
    }
    @Test
    public void testGenerateFibonacci_EmptyArrayForZero() {
        // Test: n == 0 sollte ein leeres Array zurückgeben
        int[] result = calculator.generateFibonacci(0);
        assertEquals(0, result.length);
    }
    @Test
    public void testGenerateFibonacci_FirstTwoValues() {
        // Test: Die ersten beiden Werte sollten 0 und 1 sein
        int[] result = calculator.generateFibonacci(2);
        assertEquals(0, result[0]);
        assertEquals(1, result[1]);
    }

    @Test
    public void testGenerateFibonacci_CorrectSequence() {
        // Test: Überprüfen, ob die Fibonacci-Reihe korrekt generiert wird
        int[] expected = {0, 1, 1, 2, 3, 5, 8, 13};
        int[] result = calculator.generateFibonacci(8);
        assertArrayEquals(expected, result);
    }
}