import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUpCalculator() {
        calculator = new Calculator();
    }

    @AfterEach
    public void printEnd() {
        System.out.println("Test abgeschlossen");
    }

    @Test
    public void testAdd() {
        assertEquals(5, calculator.add(2, 3), "2 + 3 sollte 5 ergeben");
    }

    @ParameterizedTest
    @CsvSource({"1,2,3","4,7,11","9,17,26"})
    public void testAddWithParams(int a, int b, int e){
        assertEquals(e,calculator.add(a,b));
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
        assertEquals(2, calculator.divide(6, 3), "6 : 3 sollte 2 ergeben");
    }

    @Test
    public void testDivideByNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> calculator.divide(6, 0), "Die Fehlermeldungen stimmen nicht überein");
        assertEquals(exception.getMessage(), "Cannot divide by zero.");
    }

    @Test
    public void testArrayNotNull() {
        assertNotNull(calculator.generateFibonacci(0));
    }

    @Test
    public void testArrayNotEmpty() {
        int[] testArray = calculator.generateFibonacci(5);
        assertTrue(testArray.length > 0);
    }

    @Test
    public void testArrayIsEmpty() {
        int[] emptyArray = new int[]{};
        assertArrayEquals(emptyArray, calculator.generateFibonacci(0));
    }

    @Test
    public void testFirstValuesCorrect() {
        int[] correctValues = new int[]{0, 1};
        int[] testValues = calculator.generateFibonacci(2);
        assertArrayEquals(correctValues, testValues);
    }

    @Test
    public void testValuesCorrect() {
        int[] correctValues = new int[]{0, 1, 1, 2, 3, 5, 8, 13};
        int[] testValues = calculator.generateFibonacci(8);
        assertArrayEquals(correctValues, testValues);
    }

    @Test
    public void testCalculatingTimeForSmallNumbers() {
        assertTimeout(Duration.ofSeconds(1), () -> calculator.generateFibonacci(100), "Berechnungszeit für 100 Fibonacci Zahlen dauerte länger als 1sec");
    }

    @Test
    public void testCalculatingTimeForMidiNumbers() {
        assertTimeout(Duration.ofSeconds(1), () -> calculator.generateFibonacci(10000), "Berechnungszeit für 10.000 Fibonacci Zahlen dauerte länger als 1sec");
    }

    @Test
    public void testCalculatingTimeForLargeNumbers() {
        assertTimeout(Duration.ofSeconds(1), () -> calculator.generateFibonacci(1000000000), "Berechnungszeit für 1.000.000.000 Fibonacci Zahlen dauerte länger als 1sec");
    }
}