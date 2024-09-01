package Practical02.Question2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Task {
    String desc;
    int priority;

    public Task  (String desc, int priority){
        this.desc = desc;
        this.priority = priority;
    }

    public String toString(){
        return "Task:" + this.desc + "\nPriority: " + this.priority;
    }

}

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Task> pq = new PriorityQueue<>(10, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.priority - o2.priority;
            }
        });

        boolean contd = true;

        while(contd) {
        System.out.println("Welcome to Priority Todo List!");
        System.out.println("Choose from the following options - ");
        System.out.println("1. Add a Task to Todo List");
        System.out.println("2. Remove a Task");
        System.out.println("3. Display the Current Todo List");
        System.out.println("4. Exit");

        int opt,priority;
        String desc;

        Scanner sc = new Scanner(System.in);
        opt = sc.nextInt();
        sc.nextLine();

            switch (opt){
                case 1:
                    System.out.println("Enter the task details:");
                    desc = sc.nextLine();
                    System.out.println("Enter the Priority of Task:");
                    priority = sc.nextInt();
                    pq.add(new Task(desc,priority));
                    System.out.println(pq);
                    break;

                case 3:
                    System.out.println("Here is the List of tasks");
                    for (Task task: pq ) System.out.println(task.toString());
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + opt);
            }
        }

    }
}
