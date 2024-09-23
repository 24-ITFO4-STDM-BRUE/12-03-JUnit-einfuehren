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
        assertEquals(2, calculator.divide(4, 2), "4 / 2 sollte 2 ergeben");
    }

    @Test
    public void testDivideByZero() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> calculator.divide(1, 0), "Teilen durch 0 sollte eine IllegalArgumentException werfen");
        assertEquals("Cannot divide by zero.", exception.getMessage(), "IllegalArgumentException sollte Cannot divide by zero wiedergeben");
    }

    @Test
    public void testGenerateFibonacciNotNull(){
        assertNotNull(calculator.generateFibonacci(5), "GenerateFibonacci mit n > 0 sollte nicht null sein");
        }

    @Test
    public void testGenerateFibonacciIsEmpty(){
        assertArrayEquals(new int[]{},calculator.generateFibonacci(0), "GenerateFibonacci mit n = 0 sollte leer sein");
        }

    @Test
    public void testGenerateFibonacci(){
        assertArrayEquals(new int[]{0,1,1,2,3}, calculator.generateFibonacci(5), "GenerateFibonacci mit n = 5 sollte [0, 1, 1, 2, 3]");
        }

    @Test
    public void testGenerateFibonacciTimeout(){
        assertTimeout(Duration.ofSeconds(1), () -> calculator.generateFibonacci(5000000), "GenerateFibonacci sollte auch bei größeren Zahlen in unter 1 sek laufen");
    }
}