import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTimeout;

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
    public void testdivide1() {assertEquals(10, calculator.divide(20, 2), "20 : 2 sollte 10 ergeben");
    }
    @Test
    public void testdivide2() {assertEquals(5, calculator.divide(20, 4), "20 : 4 sollte 5 ergeben");
    }

    /*public void testdivide3() {
    Exception exception = assertThrows(IllegalArgumentException.class, () ->
            calculator.divide(1, 0));

        {
            assertEquals("Cannot divide by zero.", exception.getMessage());
        }

        IllegalArgumentException exception2 =
                assertThrows(IllegalArgumentException.class, () -> {
                    throw new IllegalArgumentException("expected message");
                });
        assertEquals("expected message", exception.getMessage());
    }*/
    @Test
    public void testnotnull()
    {assertNotNull(calculator.generateFibonacci(2),
            "das werte ist nicht null sein");
    }
    @Test
    public void testgleich0(){
        int[] arra=new int[0];
        assertArrayEquals(arra,calculator.generateFibonacci(5),"Das Wert ist grosser als 0");
    }
    @Test
    public void sequenz (){
        int[] arra ={0,3,6,4,8,4};
        assertArrayEquals(arra, calculator.generateFibonacci(6)," 6");
    }
    @Test
    public void testtime(){
        assertTimeout(Duration.ofSeconds(1),()->{calculator.generateFibonacci(100);});
    }
}