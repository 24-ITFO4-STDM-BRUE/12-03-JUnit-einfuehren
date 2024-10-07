import java.lang.Math;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
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

    public int gcd(int a, int b) {
        if ( b == 0 ) return a;
        return gcd(b, a % b);
    }

    public boolean isPrime(int a) {
        if (a <= 1) {
            return false;
        }
        for (int i = 2; i < a; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

    public long AddAsStream(List<Integer> numbers) {
        Stream<Integer> stream = numbers.stream();
        IntSummaryStatistics result = stream.collect(Collectors.summarizingInt(Integer::intValue));
        return result.getSum();
    }

}