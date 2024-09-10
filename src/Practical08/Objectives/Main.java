package Practical08.Objectives;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int number = 10;

        Thread factorialThread = new Thread(new FactorialCalculator(number));
        Thread factorsThread = new Thread(new FactorsCalculator(number));

        factorialThread.start();
        factorsThread.start();

        try {
            factorialThread.join();
            factorsThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread finished.");
    }
}

class FactorialCalculator implements Runnable {
    private int number;

    public FactorialCalculator(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        long factorial = calculateFactorial(number);
        System.out.println("Factorial of " + number + " is: " + factorial);
    }

    private long calculateFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return n * calculateFactorial(n - 1);
    }
}

class FactorsCalculator implements Runnable {
    private int number;

    public FactorsCalculator(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        List<Integer> factors = calculateFactors(number);
        System.out.println("Factors of " + number + " are: " + factors);
    }

    private List<Integer> calculateFactors(int n) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (n % i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }
}