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

    public void deposit(int amount) {
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }
}

class Person implements Runnable {
    private String name;
    private BankAccount account;
    private boolean isWithdrawing;
    private int amount;

    public Person(String name, BankAccount account, boolean isWithdrawing, int amount) {
        this.name = name;
        this.account = account;
        this.isWithdrawing = isWithdrawing;
        this.amount = amount;
    }

    @Override
    public void run() {
        if (isWithdrawing) {
            withdraw();
        } else {
            deposit();
        }
    }

    private void withdraw() {
         synchronized (account) {
        System.out.println(name + " is about to withdraw " + amount);
        if (account.getBalance() >= amount) {
            try {
                Thread.sleep(100); // Simulate some processing time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.withdraw(amount);
            System.out.println(name + " has withdrawn " + amount);
        } else {
            System.out.println(name + " cannot withdraw due to insufficient funds");
        }
         }
    }

    private void deposit() {
         synchronized (account) {
        System.out.println(name + " is about to deposit " + amount);
        try {
            Thread.sleep(100); // Simulate some processing time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account.deposit(amount);
        System.out.println(name + " has deposited " + amount);
         }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the initial balance: ");
        int initialBalance = scanner.nextInt();

        BankAccount account = new BankAccount(initialBalance);

        Thread ryan = new Thread(new Person("Ryan", account, true, 50));
        Thread monica = new Thread(new Person("Monica", account, true, 100));

        ryan.start();
        monica.start();

        try {
            ryan.join();
            monica.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final balance: " + account.getBalance());
        scanner.close();
    }
}