import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int add(int[] a) {
        Stream<Integer> stream = (Stream<Integer>) Arrays.stream(a);
        AtomicInteger sum = new AtomicInteger();
        stream.forEach(n -> sum.addAndGet(n));
        return sum.get();
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

    public double average(int[] a) {
        int sum = add(a);
        return sum / a.length;
    }

    public int max(int[] a) {
        Stream<Integer> stream = (Stream<Integer>) Arrays.stream(a);
        return stream.max((e1, e2) -> e1 - e2).get();
    }

    public int min(int[] a) {
        Stream<Integer> stream = (Stream<Integer>) Arrays.stream(a);
        return stream.min((e1, e2) -> e1 - e2).get();
    }

    public int[] filterEven(int[] a) {
        Stream<Integer> stream = (Stream<Integer>) Arrays.stream(a);
        stream = stream.filter(n -> n % 2 == 0);

        Integer[] arrInteger = stream.toArray(Integer[]::new);
        int[] ret = new int[arrInteger.length];
        Arrays.setAll(ret, i -> arrInteger[i]);

        return ret;
    }

    public int[] generateFibonacci(int n) {
        if (n <= 0) return new int[]{};
        int[] fib = new int[n];
        fib[0] = 0;
        if(n > 1) {
            fib[1] = 1;
            for (int i = 2; i < n; i++) {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
        }
        return fib;
    }

    public double power(int base, int exponent) {
        if (exponent == 0) return 1;

        boolean negExp = false;
        if (exponent < 0) {
            exponent *= -1;
            negExp = true;
        }

        double result = base;
        for (int i = 1; i < exponent; i++) {
            result *= base;
        }
        if (negExp) {
            result = 1 / result;
        }

        return result;
    }

    public long factorial(int n) {
        if (n < 0)
            throw new IllegalArgumentException("Für negative Zahlen kann keine Fakultät berechnet werden.");
        if (n == 0)
            return 1;

        long result = n;
        for (int i = n - 1; i > 0; i--) {
            result *= i;
        }

        return result;
    }

    public int gcd(int a, int b) {
        int ret = 1;
        for (int i = Math.min(a, b); i > 0; i--) {
            if (a % i == 0 && b % i == 0) {
                ret = i;
                break;
            }
        }
        return ret;
    }

    public boolean isPrime(int n) {
        if (n <= 1)
            return false;

        for (int i = n - 1; i > 1; i--) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public double sqrt(double n) {
        if (n < 0)
            throw  new IllegalArgumentException();

        return Math.sqrt(n);
    }


}