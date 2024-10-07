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

    // Test für positive Exponenten
    @Test
    public void testPowerPositiveExponent() {
        assertEquals(8, calculator.power(2, 3), "2^3 sollte 8 ergeben");
        assertEquals(125, calculator.power(5, 3), "5^3 sollte 125 ergeben");
    }

    // Test für exponent = 0
    @Test
    public void testPowerZeroExponent() {
        assertEquals(1, calculator.power(5, 0), "5^0 sollte 1 ergeben");
        assertEquals(1, calculator.power(0, 0), "0^0 sollte 1 ergeben");
    }

    // Test für negative Exponenten
    @Test
    public void testPowerNegativeExponent() {
        assertEquals(0.25, calculator.power(2, -2), 0.0001, "2^-2 sollte 0.25 ergeben");
        assertEquals(0.2, calculator.power(5, -1), 0.0001, "5^-1 sollte 0.2 ergeben");
    }

    // Test für n = 0
    @Test
    public void testFactorialOfZero() {
        assertEquals(1, calculator.factorial(0), "0! sollte 1 ergeben");
    }

    // Test für positive Werte
    @Test
    public void testFactorialOfFive() {
        assertEquals(120, calculator.factorial(5), "5! sollte 120 ergeben");
    }

    // Test für größere Werte
    @Test
    public void testFactorialOfTen() {
        assertEquals(3628800, calculator.factorial(10), "10! sollte 3628800 ergeben");
    }

    // Test für negative Werte
    @Test
    public void testFactorialOfNegativeNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.factorial(-1));
        assertEquals("Fakultät ist nur für nicht-negative Zahlen definiert.", exception.getMessage());
    }
    // Tests for the gcd method
    @Test
    public void testGcdWithCommonDivisor() {
        assertEquals(6, calculator.gcd(54, 24), "Der ggT von 54 und 24 sollte 6 sein.");
        assertEquals(12, calculator.gcd(36, 24), "Der ggT von 36 und 24 sollte 12 sein.");
    }

    @Test
    public void testGcdWithPrimeNumbers() {
        assertEquals(1, calculator.gcd(17, 13), "Der ggT von 17 und 13 sollte 1 sein, da beide Primzahlen sind.");
    }

    @Test
    public void testGcdWithZero() {
        assertEquals(5, calculator.gcd(5, 0), "Der ggT von 5 und 0 sollte 5 sein.");
        assertEquals(7, calculator.gcd(0, 7), "Der ggT von 0 und 7 sollte 7 sein.");
        assertEquals(0, calculator.gcd(0, 0), "Der ggT von 0 und 0 sollte 0 sein.");
    }
    // Tests for the isPrime method
    @Test
    public void testIsPrimeWithPrimeNumbers() {
        assertTrue(calculator.isPrime(2), "2 sollte eine Primzahl sein.");
        assertTrue(calculator.isPrime(11), "11 sollte eine Primzahl sein.");
        assertTrue(calculator.isPrime(13), "13 sollte eine Primzahl sein.");
    }

    @Test
    public void testIsPrimeWithNonPrimeNumbers() {
        assertFalse(calculator.isPrime(4), "4 sollte keine Primzahl sein.");
        assertFalse(calculator.isPrime(9), "9 sollte keine Primzahl sein.");
        assertFalse(calculator.isPrime(15), "15 sollte keine Primzahl sein.");
    }

    @Test
    public void testIsPrimeWithEdgeCases() {
        assertFalse(calculator.isPrime(0), "0 sollte keine Primzahl sein.");
        assertFalse(calculator.isPrime(1), "1 sollte keine Primzahl sein.");
        assertTrue(calculator.isPrime(3), "3 sollte eine Primzahl sein.");
    }
    @Test
    public void testSumOfArray() {
        int[] numbers = {1, 2, 3, 4, 5};
        assertEquals(15, calculator.sumOfArray(numbers), "Die Summe sollte 15 sein.");
    }

}
