/**
 * A human player who chooses a move by clicking a board cell.
 * Demonstrates inheritance and method overriding (polymorphism).
 */
public class HumanPlayer extends Player {
    public HumanPlayer(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public int chooseMove(GameBoard board, int position) {
        return position;
    }
}
