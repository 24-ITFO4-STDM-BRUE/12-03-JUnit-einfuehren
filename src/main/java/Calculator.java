import com.sun.org.apache.bcel.internal.generic.INEG;

import java.util.List;

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
    public Integer summeStream(List<Integer> integerArrayList){
        Integer sum = integerArrayList.stream()
                .reduce(0, Integer::sum);
        return sum;
    }

    public double summeStreamZwei(List<Integer> intArrList){
        return intArrList.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
    }

    public Integer summeStreamDrei(List<Integer> intArrList){
        return intArrList.stream().mapToInt(Integer::intValue).max().orElse(0);
    }

    public Integer summeStreamVier(List<Integer> intArrList){
        return intArrList.stream().mapToInt(Integer::intValue).min().orElse(0);
    }

    public Integer streamFilterOdd(List<Integer> intArrList){
        return intArrList.stream().mapToInt(Integer::intValue).min().orElse(0);
            //.filter(number -> number % 2 == 1)
              //  .collect(Collectors.toList());
    }
}