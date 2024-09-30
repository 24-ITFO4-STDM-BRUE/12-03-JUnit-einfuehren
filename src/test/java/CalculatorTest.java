import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @BeforeEach
    public void createNewCalculator() {
        calculator = new Calculator();
    }

    @AfterEach
    public void afterTest() {
        System.out.println("Test abgeschlossen.");
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
    public void testDivide() { assertEquals(6, calculator.divide(18, 3), "18 / 3 sollte 6 ergeben"); }

    @Test
    public void testDivideZero() { assertThrows(IllegalArgumentException.class, () -> calculator.divide(2, 0), "Teilen durch 0 sollte eine IllegalArgumentException schmeißen."); }

    @Test
    public void testFibonacciNotNull() { assertNotNull(calculator.generateFibonacci(5), "generateFibonacci darf bei Zahlen > 0 nicht null zurückgeben."); }

    @Test
    public void testFibonacciZero() { assertArrayEquals(new int[]{}, calculator.generateFibonacci(0), "generateFibonacci soll bei 0 ein leeres Array zurückgeben."); }

    @Test
    public void testFibonacciFirstTwo() { assertArrayEquals(new int[]{ 0, 1 }, calculator.generateFibonacci(2), "Die Zahlenreihe muss mit 0, 1 beginnen."); }

    @Test
    public void testFibonacci() { assertArrayEquals(new int[]{ 0, 1, 1, 2, 3 }, calculator.generateFibonacci(5), "Die Fibonacci-Reihe der Länge 5 muss so aussehen: [0, 1, 1, 2, 3]."); }

    @Test
    public void testFibonacciTimeout() { assertTimeout(Duration.ofSeconds(1), () -> calculator.generateFibonacci(100000000), "Die Generierung der Fibonacci-Reihe sollte nicht länger als eine Sekunde dauern."); }

    @Test
    public void testPower() { assertEquals(8, calculator.power(2, 3), "2^3 soll 8 ergeben."); }

    @Test
    public void testPowerExponentZero() { assertEquals(1, calculator.power(5, 0), "Hoch 0 soll immer 1 ergeben."); }

    @Test
    public void testPowerExponentNegative() { assertEquals(0.125, calculator.power(2, -3), "2^-3 soll 0.125 ergeben."); }

    @Test
    public void testFactorial() { assertEquals(120, calculator.factorial(5), "5! soll 120 ergeben."); }

    @Test
    public void testFactorialZero() { assertEquals(1, calculator.factorial(0), "0! soll 1 ergeben."); }

    @Test
    public void testFactorialNegative() { assertThrows(IllegalArgumentException.class, () -> calculator.factorial(-1), "Bei negativen Zahlen soll factorial() eine Exception schmeißen."); }

    @Test
    public void testGcd() { assertEquals(6, calculator.gcd(54, 24), "Der größte gemeinsame Teiler von 54 und 24 ist 6."); }

    @Test
    public void testGcdPrime() { assertEquals(1, calculator.gcd(17, 13), "Der größte gemeinsame Teiler von 17 und 13 ist 1."); }

    @Test
    public void testPrimeTrue() { assertTrue(calculator.isPrime(11), "11 ist eine Primzahl."); }

    @Test
    public void testPrimeFalse() { assertFalse(calculator.isPrime(4), "4 ist keine Primzahl."); }

    @Test
    public void testPrimeNegative() { assertFalse(calculator.isPrime(-7), "Negative Zahlen können keine Primzahl sein."); }

    @Test
    public void testSqrt() { assertEquals(3, calculator.sqrt(9), "Die Quadratwurzel von 9 ist 3."); }

    @Test
    public void testSqrtDecimal() { assertEquals(1.414, calculator.sqrt(2), 0.0005, "Die Quadratwurzel von 2 ist 1.141."); }

    @Test
    public void testSqrtNegative() { assertThrows(IllegalArgumentException.class, () -> calculator.sqrt(-2), "Bei negativem Input soll sqrt eine Exception werfen."); }
}