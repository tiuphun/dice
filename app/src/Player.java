import java.util.*;

public class Player {
    private String name;
    private int points;

    public Player(String name) {
        this.name = name;
        this.points = 0;
    }

    public int rollDice() {
        Random random = new Random();
        int diceNo = random.nextInt(4) + 1;
        Dice dice = new Dice(diceNo);
        return dice.roll(diceNo);
    }

    public void expressGameOver() {
        Random random = new Random();
        int expressionNo = random.nextInt(10) + 1;
        switch (expressionNo) {
            case 1 -> System.out.println("Better luck next time!");
            case 2 -> System.out.println("I'll get you next time!");
            case 3 -> System.out.println("Congratulations to the winner!");
            case 4 -> System.out.println("I need to practice more.");
            case 5 -> System.out.println("That was a tough game.");
            case 6 -> System.out.println("I made some mistakes, but was fun.");
            case 7 -> System.out.println("I'll come back stronger in the next game.");
            case 8 -> System.out.println("Well played, everyone!");
            case 9 -> System.out.println("I enjoyed playing, even though I lost.");
            case 10 -> System.out.println("Oh no! I lost the game.");
            default -> System.out.println("Game over!");
        }
    }

    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }
}
