import java.util.Arrays;
import java.lang.Math;

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
        if (n <= 0) {
            return new int[]{};
        }
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

    public double power(double a, double b) {
        return Math.pow(a,b);
    }

    public long factorial(int a) {
        long result = 1;

        for (int factor = 2; factor <= a; factor++) {
            result *= factor;
        }

        return result;
    }
}