import java.util.*;
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
        if(n <= 0) return new int[]{};
        int[] fib = new int[n];
        fib[0] = 0;
        if(n>1) {
            fib[1] = 1;
            for(int i = 2; i < n; i++) {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
        }
        return fib;
    }

    public int powerCalc(int base, int power) {
        return (int) Math.pow(base, power);
    }

    public int factorial(int factor) {
        if(factor <= 2){
            return factor;
        }
        return factor * factorial(factor -1);
    }

    public int gcd(int firstDiv, int secondDiv) {
        return secondDiv==0 ? firstDiv : gcd(secondDiv, firstDiv % secondDiv);
    }

    public boolean isPrime(int number) {

        if (number <= 1)
            return false;

        if (number == 2 || number == 3)
            return true;

        if (number % 2 == 0 || number % 3 == 0)
            return false;

        for (int i = 5; i <= Math.sqrt(number); i = i + 6)
            if (number % i == 0 || number % (i + 2) == 0)
                return false;

        return true;
    }

    public int streamAdd(List<Integer> numbers) {
        Stream<Integer>numberStream = numbers.stream();
        return numberStream.mapToInt(i -> i).sum();

    }

    public double streamAvg(List<Integer> numbers) {
        return ((double) streamAdd(numbers) / numbers.parallelStream().count());
    }

    public double streamMax(List<Integer> numbers) {
        OptionalInt number = numbers.stream().mapToInt(i -> i).max();
        return number.orElse(0);
    }

    public double streamMin(List<Integer> numbers) {
        OptionalInt number = numbers.stream().mapToInt(i -> i).min();
        return number.orElse(0);
    }

    public List<Integer> streamFilterByEven(List<Integer> inputList) {
        List<Integer> results = new ArrayList<>();
        inputList.stream().forEach(x -> {if(x % 2 == 0) results.add(x);});
        return results;
    }

    public Map<Integer, Integer> streamMapEvenAndSqr(List<Integer> inputList) {
        List<Integer>evenOnly = streamFilterByEven(inputList);
        Map<Integer, Integer> results = new HashMap<>();
        evenOnly.stream().forEach(x -> results.put(x, (int) Math.pow(x, 2)));
        return results;
    }

}
