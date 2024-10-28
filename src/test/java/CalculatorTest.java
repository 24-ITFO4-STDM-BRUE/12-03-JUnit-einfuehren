import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
}