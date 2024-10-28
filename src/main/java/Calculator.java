import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;

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

    public int sum(int[] numbers){
       return Arrays.stream(numbers).sum();
    }

    public OptionalDouble average(int[] numbers){
        return Arrays.stream(numbers).average();
    }

    public OptionalInt maxNumber(int[] numbers){
        return Arrays.stream(numbers).max();
    }

    public OptionalInt minNumber(int[] numbers){
        return Arrays.stream(numbers).min();
    }

    public List<Integer> getEvenNumbers(Integer[] numbers){
        var x = Arrays.asList(numbers);
        return  x.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
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

    public int power(int base, int exponent) {
        int result = 1;
        for (int e = 0; e < exponent; e++) {
            result *= base;
        }
        return result;
    }

    public int factorial(int n) {
        int t = 1;
        for (int c = 1; c <= n; c++) {
            t = t * c;
        }
        return t;
    }

    public int gcd(int a, int b) {
        int r;
        while (b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public boolean isPrime(int n){
        if(n < 2) {
            return false;
        }
        for(int i = 2; i < n; i++) {
            if(n % i == 0)
                return false;
        }
        return true;
    }
}