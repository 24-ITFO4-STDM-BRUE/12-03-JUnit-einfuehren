import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @CsvSource({"3,2,1", "6,5,1", "6,2,4", "1,8,-7", "99,0,99"})
    public void testAddPara(int result, int a, int b){
        assertEquals(result, calculator.add(a,b));
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
        assertTimeout(Duration.ofSeconds(1), ()->calculator.generateFibonacci(9999999));
    }

    @ParameterizedTest
    @CsvSource({"8,2,3", "1,5,0"})
    public void testPower(int result, int base, int exponent){
        assertEquals(result, calculator.power(base,exponent));
    }

    @ParameterizedTest
    @CsvSource({"120,5", "1,0"})
    public void testFactorial(int result, int n){
        assertEquals(result, calculator.factorial(n));
    }

    @ParameterizedTest
    @CsvSource({"6,54,24", "1,17,13"})
    public void testGCD(int result, int base, int exponent){
        assertEquals(result, calculator.gcd(base,exponent));
    }

    @ParameterizedTest
    @CsvSource({"true,2", "true,11", "false,4", "false,9"})
    public void testIsPrime(boolean result, int n){
        assertEquals(result, calculator.isPrime(n));
    }
}