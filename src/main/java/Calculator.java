import java.math.BigDecimal;
import java.math.RoundingMode;
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

    public int[] generateFibonacci(int n){
        if(n <= 0) return new int[]{};
        int[] fib = new int[n];
        fib[0] = 0;
        if(n > 1){
            fib[1] = 1;
            for (int i = 2; i < n; i++){
                fib[i] = fib [i - 1] + fib[i - 2];
            }
        }
        return fib;
    }

    public int power(int base, int exponent){
        return (int) Math.pow(base, exponent);
    }

    public int factorial(int n){
        if (n == 0){
            return 1;
        }
        return n * factorial(n - 1);
    }

    public int  gcd(int a, int b){
        int teiler;
        teiler = Math.min(a, b);
        while(a % teiler !=0 || b % teiler !=0){
            teiler--;
        }
        return teiler;
    }

    public boolean isPrime(int n){
        if (n < 1) return false;
        if (n == 1) return true;

        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }

    public double sqrt(double n){
        return Math.sqrt(n);
    }

    public double round(double n, int spaces){
        BigDecimal bd = new BigDecimal(Double.toString(n));
        bd = bd.setScale(spaces, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public double summe(double[] input){
        return Arrays.stream(input).sum();
    }

    public double durchschnitt(double[] input){
        return Arrays.stream(input).sum() / Arrays.stream(input).count();
    }

    public double max(double[] input){
        return Arrays.stream(input).max().getAsDouble();
    }

    public double min(double[] input){
        return Arrays.stream(input).min().getAsDouble();
    }

    public double[] filterGerade(double[] input){
        return Arrays.stream(input).filter(n -> n%2 == 0).toArray();
    }

}