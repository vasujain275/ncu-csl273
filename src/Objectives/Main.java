package Objectives;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static List<String> readFile(String filename) throws IOException {
        // Read all lines and split each line into words
        return Files.lines(Paths.get(filename))
                .flatMap(line -> Stream.of(line.split("\\s+")))
                .collect(Collectors.toList());
    }

    public static void displayWords(List<String> words, String description) {
        System.out.println("\n" + description + ":");
        System.out.println(words);
        System.out.println("Number of words: " + words.size());
    }

    public static List<String> reverseWords(List<String> words) {
        List<String> reversed = new ArrayList<>(words);
        Collections.reverse(reversed);
        return reversed;
    }

    public static List<String> getPlurals(List<String> words) {
        return words.stream()
                .filter(word -> word.endsWith("s"))
                .collect(Collectors.toList());
    }

    public static List<String> removePlurals(List<String> words) {
        return words.stream()
                .filter(word -> !word.endsWith("s"))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the filename: ");
        String filename = scanner.nextLine();

        try {
            List<String> words = readFile(filename);

            displayWords(words, "All words");

            List<String> reversedWords = reverseWords(words);
            displayWords(reversedWords, "Words in reverse order");

            List<String> plurals = getPlurals(words);
            displayWords(plurals, "Plural words (ending with 's')");

            List<String> nonPlurals = removePlurals(words);
            displayWords(nonPlurals, "Words with plurals removed");

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
