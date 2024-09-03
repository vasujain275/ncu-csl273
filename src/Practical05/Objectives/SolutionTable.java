package Practical05.Objectives;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

public class SolutionTable {
    public static void main(String[] args) {
        Hashtable<String,String> ht = new Hashtable<>();
        try {
            FileReader dictReader = new FileReader("/home/vasu/personal/ncu-csl273/src/Practical05/Objectives/dictionary.txt");
            Scanner sc = new Scanner(dictReader);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] lineArr = line.split("=");
                ht.put(lineArr[0],lineArr[1]);
            }
            sc.close();
            dictReader.close();

            FileReader wordReader = new FileReader("/home/vasu/personal/ncu-csl273/src/Practical05/Objectives/words.txt");
            Scanner sw = new Scanner(wordReader);
            while (sw.hasNextLine()){
                String word = sw.nextLine();
                if(ht.containsKey(word)){
                    System.out.println(word + " = " + ht.get(word).toString());
                } else {
                    System.out.println(word + "is misspelled!");
                }

            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
