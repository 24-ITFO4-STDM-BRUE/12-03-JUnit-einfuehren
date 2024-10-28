import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Duration;
import java.util.*;


import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @AfterEach
    public void printEnd() {
        System.out.println("Test abgeschlossen");
    }

    //region Add
    @Test
    public void testAdd() {
        assertEquals(5, calculator.add(2, 3), "2 + 3 sollte 5 ergeben");
    }

    @ParameterizedTest
    @CsvSource({"1,2,3", "4,7,11", "9,17,26"})
    public void testAddWithParams(int a, int b, int e) {
        assertEquals(e, calculator.add(a, b));
    }
    //endregion

    //region Subtract
    @Test
    public void testSubtract() {
        assertEquals(1, calculator.subtract(5, 4), "5 - 4 sollte 1 ergeben");
    }
    //endregion

    //region Multiply
    @Test
    public void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3), "2 * 3 sollte 6 ergeben");
    }


    //region Maps
    @Test
    public void testCountWords(){
        Calculator calculator = new Calculator();
        Map<String, Long> expected = new HashMap<>();
        expected.put("Dies", 1L);
        expected.put("ist", 1L);
        expected.put("ein", 1L);
        expected.put("Text", 2L);
        expected.put("über", 1L);
        expected.put("Java", 1L);
        expected.put("Java,", 1L);
        expected.put("geschrieben", 1L);
        expected.put("in", 2L);
        expected.put("als", 1L);
        expected.put("einem", 1L);
        expected.put("String", 1L);
        assertEquals(expected, calculator.countWords("Dies ist ein Text über Java, geschrieben in Java als Text in einem String"));
    }

    @Test
    public void testSingleWord() {
        Calculator calculator = new Calculator();
        String singleWord = "Java";

        List<String> result = calculator.splitString(singleWord).collect(Collectors.toList());
        assertEquals(1, result.size(), "Es sollte genau ein Wort im Stream geben.");
        assertEquals("Java", result.get(0), "Das Wort sollte 'Java' sein.");
    }

    @Test
    public void testMultipleWordsWithSpaces() {
        String text = "Java Streams API";

        List<String> result = calculator.splitString(text).collect(Collectors.toList());
        assertEquals(3, result.size(), "Es sollte drei Wörter im Stream geben.");
        assertEquals(Arrays.asList("Java", "Streams", "API"), result, "Die Wörter sollten 'Java', 'Streams' und 'API' sein.");
    }

    @Test
    public void testMultipleSpacesBetweenWords() {
        String text = "Java   Streams   API   ";

        List<String> result = calculator.splitString(text).collect(Collectors.toList());
        assertEquals(3, result.size(), "Es sollte drei Wörter im Stream geben.");
        assertEquals(Arrays.asList("Java", "Streams", "API"), result, "Die Wörter sollten 'Java', 'Streams' und 'API' sein, unabhängig von zusätzlichen Leerzeichen.");
    }

    @Test
    public void testSpecialCharacters() {
        String text = "Java-Streams, API!";

        List<String> result = calculator.splitString(text).collect(Collectors.toList());
        assertEquals(Arrays.asList("Java-Streams,", "API!"), result, "Die Methode sollte die Wörter mit Sonderzeichen als einzelne Strings zurückgeben.");
    }

    @Test
    public void testMixedCaseWords() {
        String text = "Java java JAVA";

        List<String> result = calculator.splitString(text).collect(Collectors.toList());
        assertEquals(3, result.size(), "Es sollte drei Wörter im Stream geben.");
        assertEquals(Arrays.asList("Java", "java", "JAVA"), result, "Die Wörter sollten 'Java', 'java' und 'JAVA' sein.");
    }
    //endregion

    //region Divide
    @Test
    public void testDivide() {
        assertEquals(2, calculator.divide(6, 3), "6 : 3 sollte 2 ergeben");
    }

    @Test
    public void testDivideByNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> calculator.divide(6, 0), "Die Fehlermeldungen stimmen nicht überein");
        assertEquals(exception.getMessage(), "Cannot divide by zero.");
    }
    //endregion

    //region Sum
    @Test
    public void testSum() {
        int[] num = {1,2,3};
        assertEquals(6, calculator.sum(num));
    }
    //endregion

    //region average
    @Test
    public void testAverage(){
        int[] num = {1,2,3};
        assertEquals(OptionalDouble.of(2),calculator.average(num));
    }
    //endregion

    //region Min
    @Test
    public void testMin(){
        int[] num = {1,2,3};
        assertEquals(OptionalInt.of(3),calculator.maxNumber(num));
    }

    //endregion

    //region max
    @Test
    public void testMax(){
        int[] num = {1,2,3};
        assertEquals(OptionalInt.of(1),calculator.minNumber(num));
    }
    //endregion

    //region Fibonacci
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

    //nur zu testzwecken
    @RepeatedTest(value = 5)
    public void testCalculatingTimeForLargeNumbers() {
        assertTimeout(Duration.ofSeconds(1), () -> calculator.generateFibonacci(1000000), "Berechnungszeit für 1.000.000 Fibonacci Zahlen dauerte länger als 1sec");
    }
    //endregion

    //region Power
    @Test
    public void testPositiveExponent() {
        assertEquals(8, calculator.power(2, 3));
    }

    @Test
    public void testZeroExponent() {
        assertEquals(1, calculator.power(3, 0));
    }
    //endregion

    //region Factorial
    @Test
    public void testFactorialZero() {
        assertEquals(1, calculator.factorial(0));
    }

    @Test
    public void testFactorialSmallNumber() {
        assertEquals(120, calculator.factorial(5));
    }

    @Test
    public void testFactorialLargeNumber() {
        assertEquals(3628800, calculator.factorial(10));
    }
    //endregion

    //region Gcd
    @Test
    public void testGcd() {
        assertEquals(6, calculator.gcd(54, 24));
    }

    @Test
    public void testGcdWithPrime() {
        assertEquals(1, calculator.gcd(11, 13));
    }
    //endregion

    //region IsPrime
    @Test
    public void testIsPrimeWithPrime() {
        assertTrue(calculator.isPrime(11));
    }

    @Test
    public void testIsPrimeWithoutPrime() {
        assertFalse(calculator.isPrime(51));
    }
    //endregion

    @Test
    public void testEvenNumbers(){
        List<Integer> evenNum = new ArrayList<>();
        Integer[] numbs = new Integer[]{1,2,3,4,5,6};
        evenNum.add(2);
        evenNum.add(4);
        evenNum.add(6);
        assertEquals(evenNum,calculator.getEvenNumbers(numbs));
    }
}