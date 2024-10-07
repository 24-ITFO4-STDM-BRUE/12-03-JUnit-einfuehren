import java.lang.reflect.Array;
import java.util.ArrayList;
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

    public int power(int base, int exponent){
        int i;
        int ergebnis = base;
        if (exponent == 0) { return 1; }
          for (i = 0; i < exponent-1; i++) {
              ergebnis *=base;
          }
        return ergebnis;
    }

    public int factoria(int yeah){
        int ergebnis = 1;
        for(int i=yeah;i>0;i--){
             ergebnis*=i;
        }
        return ergebnis;
    }


    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
        return (double) a / b;
    }

    public int[] generateFibonacci(int n) {
        // return empty int array
        if (n <= 0) return new int[]{};
        int[] fib = new int[n];
        fib[0] = 0;
        if (n > 1) {
            fib[1] = 1;
            for (int i = 2; i < n; i++) {
                fib[i] = fib[i - 1] + fib[i - 2];

            }
        }
        return fib; //hallo
    }

    public int gcd(int a, int b) {
        int z;
        while (b != 0) {
            z = a % b;
            a = b;
            b = z;
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

    // Mit .stream die Summe berechnet.
    public Integer summe(ArrayList<Integer> integerArrayList){
        Integer sum = integerArrayList.stream()
                .reduce(0, Integer::sum);
        return sum;
    }
}