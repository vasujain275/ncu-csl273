package Practical05.Objectives;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class SolutionMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        try {
            FileReader dictReader = new FileReader("/home/vasu/personal/ncu-csl273/src/Practical05/Objectives/dictionary.txt");
            Scanner sc = new Scanner(dictReader);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] lineArr = line.split("=");
                map.put(lineArr[0], lineArr[1]);
            }
            System.out.println(map.toString());
            sc.close();
            dictReader.close();

            FileReader wordReader = new FileReader("/home/vasu/personal/ncu-csl273/src/Practical05/Objectives/words.txt");
            Scanner sw = new Scanner(wordReader);
            while (sw.hasNextLine()) {
                String word = sw.nextLine();
                if (map.containsKey(word)) {
                    System.out.println(word + " = " + map.get(word));
                } else {
                    System.out.println(word + " is misspelled!");
                }
            }
            sw.close();
            wordReader.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
