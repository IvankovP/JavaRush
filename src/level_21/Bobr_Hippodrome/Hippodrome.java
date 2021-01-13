package level_21.Bobr_Hippodrome;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    private List<Horse> horses;
    public static Hippodrome game;

    public static void main(String[] args) throws InterruptedException {

        game = new Hippodrome(new ArrayList<>());

        List<Horse> horses = game.getHorses();
        horses.add(new Horse("Crab", 3, 0));
        horses.add(new Horse("Gusto", 3, 0));
        horses.add(new Horse("Puhliy", 3, 0));
        horses.add(new Horse("Masenga", 3, 0));
        horses.add(new Horse("Kapusto", 3, 0));

        game.run();
        game.printWinner();
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            move();
            print();
            Thread.sleep(1000);
        }
    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 5; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        double maxDist = 0;
        Horse winner = null;
        for (Horse horse : horses) {
            if (horse.getDistance() > maxDist) {
                maxDist = horse.getDistance();
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
