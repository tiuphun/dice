import java.util.*;

public class GameMaster {
    private List<Player> players;
    private int currentPlayerIndex;

    public GameMaster(List<Player> players) {
        this.players = players;
        this.currentPlayerIndex = 0;
    }

    public Player getNextPlayer() {
        Random random = new Random();
        currentPlayerIndex = random.nextInt(players.size());
        return players.get(currentPlayerIndex);
    }

    public void calculatePoints(int diceValue) {
        Player currentPlayer = players.get(currentPlayerIndex);
        int currentPlayerPoints = currentPlayer.getPoints();

        if (currentPlayerPoints == 21) {
            System.out.println("Player " + currentPlayer.getName() + " wins the game!");

        } else if (currentPlayerPoints > 21) {
            System.out.println("Player " + currentPlayer.getName() + " has " + currentPlayer.getPoints() + " points.");
            currentPlayer.setPoints(0);
            System.out.println("Player " + currentPlayer.getName() + " exceeded 21 points. Points reset to 0.");
        } else {
            currentPlayer.setPoints(currentPlayerPoints + diceValue);
            System.out.println("Player " + currentPlayer.getName() + " scored " + diceValue + " points. Your point is now " + currentPlayer.getPoints() + ".");
        }
    }
}
