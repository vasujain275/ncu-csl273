package Objectives;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        try {
            File myobj = new File("src/Objectives/test.txt");
            Scanner sc = new Scanner(myobj);
            ArrayList<String> list = new ArrayList<String>();

            while(sc.hasNext()){
                list.add(sc.next());
            }
            sc.close();

            System.out.println("All the Words - \n");
            list.forEach((word) -> System.out.print(word + " "));

            System.out.println("All words in the Reverse Order - \n");

            ArrayList<String> revList = new ArrayList<String>();

            for (int i = list.size() - 1; i >= 0; i--) {
                revList.add(list.get(i));
            }

            revList.forEach((word) -> System.out.print(word + " "));

            System.out.println("\n All the plurals - \n");

            for (String s : list) {
                if (s.endsWith("s")){
                    System.out.print(s + " ");
                }
            }

            System.out.println("\n With All plurals removed \n");

            for (int i = 0; i < list.size(); i++) {

                String word =  list.get(i);

                if(word.endsWith("s")){
                    list.remove(i);
                }
            }


            list.forEach((word) -> System.out.print(word + " "));

            System.out.println("\n Size of new list - " + list.size());


        } catch(FileNotFoundException e) {
            System.out.println("File not found error");
            e.printStackTrace();
        }
    }
}