import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private List<Player> players;
    private GameMaster gameMaster;
    private final int MAX_PLAYERS = 4;

    public Game(List<Player> players, GameMaster gameMaster) {
        this.players = players;
        this.gameMaster = gameMaster;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of players: ");
        int numPlayers = scanner.nextInt();

        if (numPlayers > MAX_PLAYERS) {
            numPlayers = MAX_PLAYERS;
            System.out.println("Maximum number of players allowed is " + MAX_PLAYERS + ". Setting number of players to " + MAX_PLAYERS + ".");
        }

        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter the name of player " + (i + 1) + ": ");
            String playerName = scanner.next();
            players.add(new Player(playerName));
        }

        for (int i = numPlayers; i < MAX_PLAYERS; i++) {
            players.add(new Player("Virtual Player " + (i + 1)));
        }

        System.out.println("Game started with " + players.size() + " players.");
    }

    public int handleTurn(Player player) {
        System.out.println("Player " + player.getName() + ", it's your turn. Roll the dice!");
        return player.rollDice();
    }

    public void end() {
        System.out.println("Game ended.");
    }

    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        GameMaster gameMaster = new GameMaster(players);
        Game game = new Game(players, gameMaster);
        int result;
        game.start();

        while (true) {
            Player currentPlayer = gameMaster.getNextPlayer();
            result = game.handleTurn(currentPlayer);
            gameMaster.calculatePoints(result);

            if (currentPlayer.getPoints() == 21) {
                break;
            }
        }

        game.end();

        System.out.println("------ CHAT -------");
        for (Player player : players) {
            player.expressGameOver();
        }
    }
}
