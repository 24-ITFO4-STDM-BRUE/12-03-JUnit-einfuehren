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
    public int power(int base, int exponent){
        if (exponent == 0)
            return 1;
        else
            return base * power(base, exponent - 1);
    }
   public int factorial(int base) {
       int ergebnis = 1;
       for (int i = base; i > 0; i--) {
           ergebnis *= i;
       }
       return ergebnis;
   }
   public int gct(int a, int b) {
        int sum = a * b;
        int gcd = 0;
        for(int i = sum; i > 0; i--){
            if(a % i == 0 && b % i == 0){
                gcd = i;
                break;
            }
        }
       return gcd;
   }

}