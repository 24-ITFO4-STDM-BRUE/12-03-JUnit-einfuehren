import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @BeforeEach
    public void Reset(){
        calculator = new Calculator();
    }

    @AfterEach
    public void msgComplete(){
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
        assertEquals(6, calculator.divide(18, 3));
    }

    @Test
    public void testDivideBulkRand() {
        int a,b;
        double result;
        for (int i = 0; i < 100; i++) {
            a = (int)(1000 * (Math.random()));
            b = (int)(1000 * (Math.random() + 0.001));
            result = (double) a / b;
            assertEquals(result, calculator.divide(a, b));
        }
    }

    @Test
    public void testDivideZero() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> calculator.divide(1,0));
        assertEquals("Cannot divide by zero.", ex.getMessage());
    }

    @Test
    public void testFibZero(){
        assertArrayEquals(new int[]{}, calculator.generateFibonacci(0));
    }

    @Test
    public void testFibOne(){
        assertArrayEquals(new int[]{0}, calculator.generateFibonacci(1));
        assertNotNull(calculator.generateFibonacci(1));
    }

    @Test
    public void testFibMany(){
        assertArrayEquals(new int[]{0,1}, calculator.generateFibonacci(2));
        assertArrayEquals(new int[]{0,1,1}, calculator.generateFibonacci(3));
        assertArrayEquals(new int[]{0,1,1,2,3,5,8,13,21}, calculator.generateFibonacci(9));
    }
    @Test
    public void testFibTime(){
        assertTimeout(Duration.ofSeconds(1), ()->calculator.generateFibonacci(99));
    }
}