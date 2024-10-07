import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;

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
    public void testDivide(){assertEquals(2,calculator.divide(6,3), "6 / 3 sollte 2 ergeben"); }

    @Test
    public void testDivideZero() {assertThrows(IllegalArgumentException.class, () -> calculator.divide(4, 0), "Solle Exception werfen."); }

    @Test
    public void testGenerateFibonacciNotNull(){assertNotNull(calculator.generateFibonacci(4),"Cool! Toll gemacht");}

    @Test
    public void testGenerateFibonacci(){assertArrayEquals(new int[]{0,1,1,2,3}, calculator.generateFibonacci(5),"Cool! Toll gemacht");}

    @Test
    public void testGenerateFibonacciEmpty(){assertArrayEquals(new int[]{}, calculator.generateFibonacci(0));}

    @Test
    public void testGenerateFibonacciCorrect(){assertArrayEquals(new int[]{0,1}, calculator.generateFibonacci(2),"Cool! Toll gemacht");}

    ///@Test
   // public void testGenerateFibonacciTimeOut(){assertTimeout(Duration.ofSeconds(1), new int[]{}, calculator.generateFibonacci(5),"Cool! Toll gemacht");}

    @Test
    public void testPower() {assertEquals(1,calculator.power(9,0));}

    @Test
    public void testFactoria() {assertEquals(120, calculator.factoria(5));}

    @Test
    public void testGcd() {assertEquals(6, calculator.gcd(54, 24));}

    @Test
    public void testPrime() {assertTrue(calculator.isPrime(13));}

    @Test
    public void testSumme() {
        ArrayList<Integer> arl = new ArrayList<Integer>();
        arl.add(1);
        arl.add(2);
        arl.add(3);
        arl.add(4);
        arl.add(5);
        assertEquals(15,calculator.summe(arl));
    }
}

