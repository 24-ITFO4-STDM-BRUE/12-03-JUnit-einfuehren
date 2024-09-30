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


    public int[] generateFibonacci (int n) {
        if (n <= 0) return new int[]{};
        int[] fib = new int[n];
        fib[0] = 0;
        if (n > 1) {
            fib[1] = 1;
            for (int i = 2; i < n; i++){
                fib[i] = fib[i - 1] + fib[i - 2];

            }
        }
        return fib;
    }

    public double power (int x, int y)  {
        double i = 1;

        if (y < 0) {

               if (x == 0) {
                   throw new IllegalArgumentException("Cannot divide by zero.");
               }
               while (y < 0) {
                   i = i / x;
                   y++;
               }
           }

         else {
          if  (y == 0) {
            i = i * x;
        }else {
              while (y > 0) {
                  i = i * x;
                  y--;
              }
          }
        }

        return i;
    };

    public int factorial(int n) {

      int ergebnis = 1;
      while (n > 0) {
        ergebnis = ergebnis * n;
        n--;
      };
      return ergebnis;
    };

    public int gcd(int x, int y) {
      int teiler = 2;
      int ergebnis = 1;

      boolean teilerGefunden = false;
      while (!teilerGefunden) {
          if (x % teiler == 0){
              if (y % (x / teiler) == 0){
                  ergebnis = x / teiler;
                  teilerGefunden = true;
              }
          }
              teiler ++;
      }

      return ergebnis;
    };


}