import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    public final Calculator calculator = new Calculator();

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
    public void testDivide() {assertEquals(2, calculator.divide(6, 3), "6 / 3 sollte 2 ergeben");}

    @Test
    void testDivideByZero() {
        {assertThrows(IllegalArgumentException.class,() -> {calculator.divide(12, 0);});
        }
    }
    @Test
    void testGenerateFibonacci() {
        {assertArrayEquals(new int[]{0, 1, 1, 2, 3},calculator.generateFibonacci(5));};
    }
    @Test
    void testGenerateFibonacciNull() {
        {assertArrayEquals(new int[]{},calculator.generateFibonacci(0));};
    }
    @Test
    void testGenerateFibonacciTime() {
        {assertTimeout(Duration.ofSeconds(1),() -> calculator.generateFibonacci(9032222));};
    }

    @Test
    void testPower(){
        assertEquals(1, calculator.power(5, 0));
    }

    @Test
    void testFactorial(){
        assertEquals(1, calculator.factorial(0));
    }

    @Test
    void testGgt(){
        assertEquals(6, calculator.gct(54, 24));
    }
}
