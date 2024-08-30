package Practical02.Objectives;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[] inputArray = input.split(" ");
        System.out.println(Arrays.toString(inputArray));
    }
}
