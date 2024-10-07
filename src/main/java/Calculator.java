import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
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
    public double power (int base, int exponent){
        double basic  = base;
        double exponenta = exponent;
      double erg=(double )Math.pow(basic,exponent);
      return erg;
    }
    public static long fakultaet(int n)
    {
        if (n < 0){
            throw new IllegalArgumentException("fakultaet ist nicht für negative Zahlen " +
                "geeignet");}
        long ergebnis = 1;
        for(int i = 1;i <= n; i++){
            ergebnis *= i;}
        return ergebnis;
    }

    public int ggt(int i, int i1) {

        return 0;
    }

    public Integer streamSum(){
        List<Integer> zahlen = Arrays.asList(1,2,3,4,5);
        Stream stream = zahlen.stream();
        int sum = zahlen.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum);
        return sum;
    }
    public Integer streamdurchnitt(){
        List<Integer> zahlen = Arrays.asList(1,2,3,4,5);
        int sum = zahlen.stream()
                .mapToInt(Integer::intValue)
                .sum();
        int durchnitt=sum/2;
        return durchnitt;
    }
    public static void main(String[] args) {
        Calculator test = new Calculator();
        test.streamdurchnitt();

    }
}