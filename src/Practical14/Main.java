package Practical14;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter language (English/French): ");
        String language = scanner.nextLine();

        GreetServiceFactory factory = new GreetServiceFactory();
        GreetService greetService = factory.getGreetService(language);

        if (greetService != null) {
            greetService.greet("Vasu");
        } else {
            System.out.println("Language not supported.");
        }

        scanner.close();
    }
}

interface GreetService {
    void greet(String name);
}

class GreetServiceFactory {
    public GreetService getGreetService(String language) {
        if (language.equalsIgnoreCase("English")) {
            return new EnglishGreetService();
        } else if (language.equalsIgnoreCase("French")) {
            return new FrenchGreetService();
        } else {
            return null;
        }
    }
}

class EnglishGreetService implements GreetService {
    @Override
    public void greet(String name) {
        System.out.println("Hello " + name);
    }
}

class FrenchGreetService implements GreetService {
    @Override
    public void greet(String name) {
        System.out.println("Bonjour " + name);
    }
}
