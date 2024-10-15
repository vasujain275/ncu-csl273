package Practical07.Objectives;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class NumberGenerator implements Runnable{
    private final Random random = new Random();
    BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

    NumberGenerator(BlockingQueue<Integer> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            int num = random.nextInt(100);
            try {
                queue.put(num);
                System.out.println("Generated: " + num);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Something went wrong!");
            }
        }
    }
}

class NumberSquare implements Runnable {
    BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

    NumberSquare(BlockingQueue<Integer> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                int num = queue.take();
                Thread.sleep(1000);
                if (num%2 == 0){
                    System.out.println("Squared (even): " + num*num);
                } else {
                    System.out.println("Its Odd: " + num);
                }

            } catch (InterruptedException e) {
                System.out.println("Something went wrong!");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

        Thread thread1 = new Thread(new NumberGenerator(queue));
        Thread thread2 = new Thread(new NumberSquare(queue));

        thread1.start();
        thread2.start();
    }
}
