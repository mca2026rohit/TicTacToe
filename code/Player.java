/**
 * Represents a player in the Tic-Tac-Toe game.
 * Demonstrates abstraction and encapsulation.
 */
public abstract class Player {
    private final String name;
    private final char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public abstract int chooseMove(GameBoard board, int position);
}
