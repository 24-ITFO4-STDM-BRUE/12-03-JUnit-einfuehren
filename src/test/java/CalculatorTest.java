import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Test abgeschlossen");
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
    public void testDivide() {
        assertEquals(2, calculator.divide(4, 2), "4 / 2 sollte 2 ergeben");
    }

    // Test for generateFibonacci(int n)
    @Test
    public void testGenerateFibonacciArrayNotNull() {
        // Test für n > 0
        int n = 5;
        int[] fibArray = calculator.generateFibonacci(n);
        assertNotNull(fibArray, "Das generierte Fibonacci-Array sollte nicht null sein.");
    }

    @Test
    public void testGenerateFibonacciArrayEmptyForZero() {
        // Test für n == 0
        int n = 0;
        int[] fibArray = calculator.generateFibonacci(n);
        assertNotNull(fibArray, "Das generierte Fibonacci-Array sollte nicht null sein, auch für n = 0.");
        assertEquals(0, fibArray.length, "Das Array sollte leer sein, wenn n = 0.");
    }

    // Tests für die gesamte Fibonacci-Sequenz für unterschiedliche Werte von n
    @Test
    public void testGenerateFibonacciWithNEqualsFive() {
        // Testet die Fibonacci-Sequenz für n = 5
        int n = 5;
        int[] expected = {0, 1, 1, 2, 3};
        int[] fibArray = calculator.generateFibonacci(n);
        assertArrayEquals(expected, fibArray, "Die Fibonacci-Sequenz für n = 5 sollte [0, 1, 1, 2, 3] sein.");
    }

    @Test
    public void testGenerateFibonacciWithNEqualsThree() {
        int n = 3;
        int[] expected = {0, 1, 1};
        int[] fibArray = calculator.generateFibonacci(n);
        assertArrayEquals(expected, fibArray, "Die Fibonacci-Sequenz für n = 3 sollte [0, 1, 1] sein.");
    }

    @Test
    public void testGenerateFibonacciWithNEqualsTwo() {
        int n = 2;
        int[] expected = {0, 1};
        int[] fibArray = calculator.generateFibonacci(n);
        assertArrayEquals(expected, fibArray, "Die Fibonacci-Sequenz für n = 2 sollte [0, 1] sein.");
    }

    @Test
    public void testGenerateFibonacciWithNEqualsOne() {
        int n = 1;
        int[] expected = {0};
        int[] fibArray = calculator.generateFibonacci(n);
        assertArrayEquals(expected, fibArray, "Die Fibonacci-Sequenz für n = 1 sollte [0] sein.");
    }

    @Test
    public void testGenerateFibonacciWithNEqualsZero() {
        int n = 0;
        int[] expected = {};
        int[] fibArray = calculator.generateFibonacci(n);
        assertArrayEquals(expected, fibArray, "Das Fibonacci-Array sollte leer sein, wenn n = 0.");
    }

    // Test, ob die Fibonacci-Zahlenberechnung für größere n innerhalb von 1 Sekunde abgeschlossen ist
    @Test
    public void testGenerateFibonacciPerformance() {
        int n = 30;
        int[] fibArray = assertTimeout(Duration.ofSeconds(1), () -> calculator.generateFibonacci(n),
                "Die Berechnung der Fibonacci-Zahlen für n = 30 sollte innerhalb von 1 Sekunde erfolgen.");

        // Überprüfe, ob das Ergebnis korrekt ist
        assertNotNull(fibArray, "Das generierte Fibonacci-Array sollte nicht null sein.");
    }
}
