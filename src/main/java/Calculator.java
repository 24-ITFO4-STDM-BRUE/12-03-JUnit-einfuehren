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
        int i;
        int ergebnis = yeah;
        for(i=yeah-1;i==1;i--){
             ergebnis = i * i-1;
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
}
