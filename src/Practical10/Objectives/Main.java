package Practical10.Objectives;

import java.util.Scanner;

class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}

class Person implements Runnable {
    private String name;
    private BankAccount account;
    private int amount;

    public Person(String name, BankAccount account, int amount) {
        this.name = name;
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            withdrawMoney();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void withdrawMoney() {
        synchronized (account) {
            if (account.getBalance() >= amount) {
                System.out.println(name + " is withdrawing $" + amount);
                account.withdraw(amount);
                System.out.println(name + " withdrew $" + amount + ". New balance: $" + account.getBalance());
            } else {
                System.out.println(name + " cannot withdraw $" + amount + ". Insufficient funds.");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the initial balance: $");
        int initialBalance = scanner.nextInt();

        BankAccount account = new BankAccount(initialBalance);

        Thread ryan = new Thread(new Person("Ryan", account, 50));
        Thread monica = new Thread(new Person("Monica", account, 100));

        System.out.println("Initial balance: $" + account.getBalance());

        ryan.start();
        monica.start();

        try {
            ryan.join();
            monica.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final balance: $" + account.getBalance());

        scanner.close();
    }
}