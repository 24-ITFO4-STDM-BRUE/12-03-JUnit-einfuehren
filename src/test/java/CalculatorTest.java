import org.junit.jupiter.api.Test;

import java.time.Duration;

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
        assertEquals(8, calculator.divide(24, 3), "24 / 3 sollte 8 ergeben");
    }

    @Test
    void testExpectedExceptionIsThrown() {
        assertThrows(IllegalArgumentException.class, () -> {calculator.divide(12, 0);});
    }

    @Test
    void testFibonacci() {
        assertArrayEquals(new int[]{0, 1, 1, 2, 3, 5}, calculator.generateFibonacci(6));
    }

    @Test
    void testFibonacciZero() {
        assertArrayEquals(new int[]{}, calculator.generateFibonacci(0));
    }

    @Test
    void testFibonacciFirstTwoValues() {
        int[] fib = calculator.generateFibonacci(8);

        assertEquals(0, fib[0]);
        assertEquals(1, fib[1]);
    }
    @Test
    void testFibonacciDuration() {
        assertTimeout(Duration.ofSeconds(1), () -> calculator.generateFibonacci(99));
    }

    @Test
    void testPower() {
        assertEquals(8, calculator.power(2, 3));
        assertEquals(0.125, calculator.power(2, -3));
        assertEquals(-0.125, calculator.power(-2, -3));
    }

    @Test
    void testFactorial() {
        assertEquals(120, calculator.factorial(5));
        assertEquals(1, calculator.factorial(0));
    }

    @Test
    void testGCD() {
        assertEquals(4, calculator.gcd(4, 8));
    }

    @Test
    void testIsPrime() {
        assertTrue(calculator.isPrime(11));
        assertTrue(calculator.isPrime(2));
        assertFalse(calculator.isPrime(4));
        assertFalse(calculator.isPrime(9));
    }
}