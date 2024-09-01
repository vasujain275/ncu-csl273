package Practical02.Objectives;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Stack<String> chars = new Stack<>();
        String[] strArray = input.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : strArray){
            if(word.endsWith(".")){
                chars.push(word.substring(0, (word.length() - 1)));

                while (!chars.empty()){
                    result.append(chars.pop()).append(" ");
                }
                result.append(". ");
            } else {
                chars.push(word);
            }
        }

        System.out.println(result.toString().trim());

    }
}
