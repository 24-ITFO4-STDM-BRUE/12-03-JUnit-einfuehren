import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @BeforeEach
    public void initCalc() {
        calculator = new Calculator();
    }

    @AfterEach
    public void endNote() {
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
    public void testDivideArgumentExep() {

        try {
            calculator.divide(1, 0);
        } catch (IllegalArgumentException ex) {
            assertTrue(true);
            return;
        }
        fail();
    }

    @Test
    public void testDivideValues() {
        assertEquals(2.0, calculator.divide(4, 2));
        assertEquals(0.5, calculator.divide(5, 10));
        assertEquals(5.0, calculator.divide(10, 2));
        assertNotEquals(10.0, calculator.divide(10, 2));
        assertTrue(calculator.divide(10, 3) > 3.3);

    }
    @Nested
    @DisplayName("FibonacciTests")
    class FibonacciTest {


        @Test
        public void testGenerateFibonacciNotNull() {
            assertNotNull(calculator.generateFibonacci(1));
        }

        @Test
        public void testGenerateFibonacciNull() {
            assertTrue(calculator.generateFibonacci(0).length == 0);
        }

        @Test
        public void testGenerateFibonacciCheckArrayValues() {
            assertArrayEquals(new int[]{0, 1, 1, 2, 3}, calculator.generateFibonacci(5));
        }

        @Test
        public void testGenerateFibonacciTimeout() {
            assertTimeout(Duration.ofSeconds(1), () -> calculator.generateFibonacci(10));
        }
    }
}