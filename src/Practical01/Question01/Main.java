package Practical01.Question01;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        System.out.print("Enter the number of lines to print: ");
        int numberOfLines = scanner.nextInt();
        scanner.close();

        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            List<String> randomLines = getRandomLines(lines, numberOfLines);
            for (String line : randomLines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    private static List<String> getRandomLines(List<String> lines, int numberOfLines) {
        List<String> randomLines = new ArrayList<>(numberOfLines);
        Random random = new Random();

        for (int i = 0; i < numberOfLines; i++) {
            int randomIndex = random.nextInt(lines.size());
            randomLines.add(lines.get(randomIndex));
        }

        return randomLines;
    }
}
