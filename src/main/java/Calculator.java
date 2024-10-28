import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
        return (double) a / b;
    }

    // Methode zum Aufteilen des Textes in einen Stream von Wörtern
    public Stream<String> splitString(String text) {
        return Arrays.stream(text.split("\\s+"));
    }

    //ToDo: Zählen der Wörter im text.
    //hint: nutzer Sie die splitString Methode (s.o.)
    public Map<String, Long> countWords(String text) {
        return null;
    }
}