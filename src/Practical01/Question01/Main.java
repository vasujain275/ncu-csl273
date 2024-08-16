package Practical01.Question01;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedReader reader;
            reader = new BufferedReader(new FileReader("src/Practical01/Question01/test.txt"));
            int lines = 0;
            while (reader.readLine() != null) lines++;
            List<String> linesList = new ArrayList<String>(lines);
            reader.close();

            File myfile = new File("src/Practical01/Question01/test.txt");
            Scanner sc = new Scanner(myfile);

            while (sc.hasNextLine()){
                linesList.add(sc.nextLine());
            }

            printRandomLines(linesList, 3);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void printRandomLines(List<String> list, int count) {
        Random rand = new Random();

        int max = list.size();

        for (int i = 0; i < count; i++) {
            int randomNumber = rand.nextInt(max - 1) + 1;
            String line = list.get(randomNumber);
            System.out.println(line);
        }

    }

}
