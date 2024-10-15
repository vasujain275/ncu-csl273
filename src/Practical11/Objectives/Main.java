package Practical11.Objectives;

import java.util.Random;
import java.util.Scanner;

class BankAccount {
    private int balance;
    private final int LIMIT = 1000;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(int amount) {
        while (balance + amount > LIMIT) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        balance += amount;
        System.out.println("Monica deposited $" + amount + ". New balance: $" + balance);
        notifyAll();
    }

    public synchronized void withdraw(int amount) {
        while (balance < amount) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        balance -= amount;
        System.out.println("Ryan withdrew $" + amount + ". New balance: $" + balance);
        notifyAll();
    }
}

class Producer implements Runnable {
    private BankAccount account;
    private Random random = new Random();

    public Producer(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            int amount = random.nextInt(100) + 100;
            account.deposit(amount);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    private BankAccount account;
    private Random random = new Random();

    public Consumer(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            int amount = random.nextInt(50) + 50;
            account.withdraw(amount);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter initial balance: $");
        int initialBalance = scanner.nextInt();
        scanner.close();

        BankAccount account = new BankAccount(initialBalance);
        Thread monicaThread = new Thread(new Producer(account), "Monica");
        Thread ryanThread = new Thread(new Consumer(account), "Ryan");

        monicaThread.start();
        ryanThread.start();

        try {
            monicaThread.join();
            ryanThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Transactions completed.");
    }
}