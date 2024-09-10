package Practical03.Objectives;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Car {
    private String licencePlate;
    public Car(String licencePlate){
        this.licencePlate = licencePlate;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    @Override
    public String toString(){
        return this.licencePlate;
    }
}

public class Main {
    public static void main(String[] args) {
        Queue<Car> street = new LinkedList<>();
        Stack<Car> driveway = new Stack<>();
        boolean contd = true;
        Scanner sc = new Scanner(System.in);

        while(contd){
            System.out.println("Welcome to VJ's Parking");
            System.out.println("Choose an Option: ");
            System.out.print("""
                    1. Add a car to Parking
                    2. Remove a car from Parking
                    3. Exit
                    """);
            System.out.print("> ");
            int opt = sc.nextInt();
            sc.nextLine();

            switch (opt){
                case 1:
                    System.out.print("Enter car License Plate Number: \n> ");
                    String num1 = sc.nextLine();
                    Car car1 = new Car(num1);
                    driveway.push(car1);
                    System.out.println("Your Car has be Parked! Here is the Driveway");
                    driveway.forEach(System.out::println);
                    System.out.print("\n\n");
                    break;

                case 2:
                    System.out.print("Enter car License Plate Number: \n> ");
                    String num2 = sc.nextLine();

                    while (!driveway.isEmpty()){
                        Car car = driveway.peek();
                        if(car.getLicencePlate().equals(num2)){
                            driveway.pop();
                            break;
                        } else {
                            street.add(driveway.pop());
                        }
                    }

                    System.out.println("Driveway Now - ");
                    driveway.forEach(System.out::println);
                    System.out.print("\n");
                    System.out.println("Street Now - ");
                    street.forEach(System.out::println);
                    System.out.print("\n");
                    break;

                case 3:
                    contd = false;
                    break;
                default:
                    System.out.println("Choose a option between 1-3!\n");
                    break;
            }
        }
    }
}
