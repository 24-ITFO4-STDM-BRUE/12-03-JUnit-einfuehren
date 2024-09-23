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
}