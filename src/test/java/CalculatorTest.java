import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @BeforeEach
    void init() {
        Calculator calculator = new Calculator();
        System.out.println("Test startet");
    }

    @AfterEach
    void teardown() {
        System.out.println("Test Abgeschlossen");
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

    @Test
    public void testDivideByZero() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> calculator.divide(1, 0), "Teilen durch 0 sollte eine IllegalArgumentException werfen");
        assertEquals("Cannot divide by zero.", exception.getMessage(), "IllegalArgumentException sollte Cannot divide by zero wiedergeben");
    }

    @Test
    public void testGenerateFibonacciNotNull() {
        assertNotNull(calculator.generateFibonacci(5), "GenerateFibonacci mit n > 0 sollte nicht null sein");
    }

    @Test
    public void testGenerateFibonacciIsEmpty() {
        assertArrayEquals(new int[]{}, calculator.generateFibonacci(0), "GenerateFibonacci mit n = 0 sollte leer sein");
    }

    @Test
    public void testGenerateFibonacci() {
        assertArrayEquals(new int[]{0, 1, 1, 2, 3}, calculator.generateFibonacci(5), "GenerateFibonacci mit n = 5 sollte [0, 1, 1, 2, 3]");
    }

    @Test
    public void testGenerateFibonacciTimeout() {
        assertTimeout(Duration.ofSeconds(1), () -> calculator.generateFibonacci(50_000_000), "GenerateFibonacci sollte auch bei größeren Zahlen in unter 1 sek laufen");
    }

    @Test
    public void testPowerPositiv() {
        assertEquals(8, calculator.power(2,3));
    }

    @Test
    public void testPowerNegativ() {
        assertEquals(0.125, calculator.power(2,-3));
    }

    @Test
    public void testPowerZero() {
        assertEquals(1, calculator.power(2,0));
    }

    @Test
    public void testFactorial() {
        assertEquals(120, calculator.factorial(5));
    }
    @Test
    public void testFactorialZero() {
        assertEquals(1, calculator.factorial(0));
    }

    @Test
    public void testGemeinsamerTeiler() {
        assertEquals(6, calculator.gcd(54, 24));
    }

    @Test
    public void testGemeinsamerTeilerPrimzahl() {
        assertEquals(1, calculator.gcd(17, 13));
    }

    @Test
    public void testIsPrime() {
        assertTrue(calculator.isPrime(11));
    }
    @Test
    public void testIsNotPrime() {
        assertFalse(calculator.isPrime(4));
    }
}