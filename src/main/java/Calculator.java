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
        if(n <= 0) return new int[]{};
        int[] fib = new int[n];
        fib[0] = 0;
        if (n > 1){
            fib[1] = 1;
            for (int i = 2; i < n; i++){
                fib[i] = fib[i - 1] + fib[i - 2];
            }
        }
        return fib;
    }

    public double power (int base, int exponent) {
        if(exponent == 0){
            return 1;
        }
        else if (exponent < 0) {
            double result = base;
            for (int i = -1; i > exponent; i--) {
                result = result * base;
            }
            return 1 / result;
        }
        else {
            double result = base;
            for (int i = 1; i < exponent; i++) {
                result = result * base;
            }
            return result;
        }
    }

    public int factorial (int n) {
        if(n == 0) {
            return 1;
        }
        else {
            int result = n;
            for(int i = n - 1; i > 0; i--){
                result = result * i;
            }
            return result;
        }
    }

    public int gcd (int a, int b) {
        if (a == 0)
            return b;
        if (b == 0)
            return a;
        if (a < b)
            return gcd(b, a);
        return gcd(b, a % b);
    }

    public boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}