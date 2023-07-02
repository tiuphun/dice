import java.util.Random;

public class Dice {
    private Random random;
    private int diceNo;

    public Dice(int diceNo) {
        this.random = new Random();
        this.diceNo = diceNo;
    }

    public int roll(int diceNo) {
        int randomNumber = random.nextInt(100) + 1; // Generate a random number between 1 and 100
        int result;
        if (randomNumber <= 20) {
            return diceNo; // 20% chance of rolling out the special respective face
        } else {
            do {
                result = random.nextInt(6) + 1; // 16% chance for the other faces (exclusive)
            } while (result == diceNo);
            return result;
        }
    }
}