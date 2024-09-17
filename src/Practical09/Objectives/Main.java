package Practical09.Objectives;

class GreetThread implements Runnable {

    private int count;

    public GreetThread(int count){
        this.count = count;
    }

    @Override
    public void run() {
        System.out.println("Hello from " + count);
        count--;
        if(count>0){
            Thread t = new Thread(new GreetThread(count));
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(new GreetThread(50));
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
