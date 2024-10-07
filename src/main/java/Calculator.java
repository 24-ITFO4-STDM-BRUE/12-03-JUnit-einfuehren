import java.util.Arrays;

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

    public int[] generateFibonacci(int n) {
        if (n <= 0) return new int[]{};
        int[] fib = new int[n];
        fib[0] = 0;
        if (n > 1) {
            fib[1] = 1;
            for (int i = 2; i < n; i++) {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
        }
        return fib;
    }

    // Methode zur Berechnung von Potenzen
    public double power(int base, int exponent) {
        if (exponent == 0) {
            return 1;  // Jede Zahl hoch 0 ist 1
        }

        double result = 1;
        int absExponent = Math.abs(exponent);

        // Für positive Exponenten
        for (int i = 0; i < absExponent; i++) {
            result *= base;
        }

        // Wenn der Exponent negativ ist, den Kehrwert des Ergebnisses nehmen
        if (exponent < 0) {
            result = 1 / result;
        }

        return result;
    }

    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Fakultät ist nur für nicht-negative Zahlen definiert.");
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Methode zur Berechnung des größten gemeinsamen Teilers (ggT)
    public int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    // Methode zur Überprüfung, ob eine Zahl eine Primzahl ist
    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        // Prüfe nur bis zur Quadratwurzel von n
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Berechnet die Summe aller Zahlen im Array.
     *
     * @param numbers Array von ganzen Zahlen
     * @return die Summe der Zahlen
     */
    public int sumOfArray(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }


}
