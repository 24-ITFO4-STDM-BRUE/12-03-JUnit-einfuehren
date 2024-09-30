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
}