package Practical06.Objectives;

import java.util.*;

class Player{
    private String name;
    private int score;

    public Player(String name,int score){
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString(){
        return "Name: " + name + " Score: " + score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}

class Checker implements Comparator<Player>{

    @Override
    public int compare(Player o1, Player o2) {
        int scoreCmp = Integer.compare(o2.getScore(),o1.getScore());
        if (scoreCmp != 0){
            return scoreCmp;
        }
        return o1.getName().compareTo(o2.getName());
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        sc.nextLine();
        for (int i=0;i<count;i++){
            String line = sc.nextLine();
            String[] lineArr = line.split(" ");
            players.add(new Player(lineArr[0],Integer.parseInt(lineArr[1])));
        }
        players.sort(new Checker());
//        players.sort(Comparator.comparing(Player::getScore, Comparator.reverseOrder())
//                .thenComparing(Player::getName));
        System.out.println(players.toString());
    }
}
