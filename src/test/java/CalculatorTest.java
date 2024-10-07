
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void init() {
        calculator = new Calculator();
    }

    @AfterEach
    public void endNote() {
        System.out.println("Test abgeschlossen");
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    public void testAdd(int param) {
        assertEquals((2 + param), calculator.add(2, param), "2 + "+ param +"  sollte "+ (2 + param) +" ergeben");
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

    @Test
    public void testPowerCalcPositivNumber() {
        assertEquals(8, calculator.powerCalc(2,3));
        assertEquals(1, calculator.powerCalc(5,0));
    }

    @Test
    public void testPowerCalcNegativeNumber() {
        assertEquals(-8, calculator.powerCalc(-2,3));
        assertEquals(1, calculator.powerCalc(-5,0));
    }

    @Test
    public void testPowerCalcZero() {
        assertEquals(1, calculator.powerCalc(0, 0));
    }

    @Test
    public void testFactorialCalcPositivNumbers() {
        assertEquals(120, calculator.factorial(5));
        assertEquals(0, calculator.factorial(0));
        assertTimeout(Duration.ofSeconds(1),() -> calculator.factorial(19));
    }

    @Test
    public void testFactorialCalcOverflow() {
        assertTrue(0>calculator.factorial(20));
    }

    @Test
    public void testGCDCalc() {
        assertEquals(6, calculator.gcd(54,24));
        assertEquals(1, calculator.gcd(17,13));
    }

    @Test
    public void testIsPrimeTruePrimes() {
        assertTrue(calculator.isPrime(2));
        assertTrue(calculator.isPrime(11));
        assertTrue(calculator.isPrime(2069));
    }

    @Test
    public void testIsPrimeNonPrimes() {
        assertFalse(calculator.isPrime(4));
        assertFalse(calculator.isPrime(9));
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
    @Test
    public void testStreamAdd() {
        assertEquals(10, calculator.streamAdd(Arrays.asList(1,2,3,4)));
    }

    @Test
    public void testStreamAvg() {
        assertEquals(40, calculator.streamAvg(Arrays.asList(50,20,15,75)));
    }

    @Test
    public void testMAx
}