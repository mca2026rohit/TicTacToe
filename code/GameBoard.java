/**
 * Stores and manages the 3x3 Tic-Tac-Toe board.
 * The board array is private to protect its state (encapsulation).
 */
public class GameBoard {
    private final char[] cells = new char[9];

    public GameBoard() {
        reset();
    }

    public void reset() {
        for (int i = 0; i < cells.length; i++) {
            cells[i] = ' ';
        }
    }

    public boolean isValidMove(int position) {
        return position >= 0 && position < 9 && cells[position] == ' ';
    }

    public boolean placeSymbol(int position, char symbol) {
        if (!isValidMove(position)) {
            return false;
        }
        cells[position] = symbol;
        return true;
    }

    public char getCell(int position) {
        if (position < 0 || position >= 9) {
            throw new IndexOutOfBoundsException("Cell position must be between 0 and 8.");
        }
        return cells[position];
    }

    public boolean hasWinner(char symbol) {
        int[][] lines = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}
        };

        for (int[] line : lines) {
            if (cells[line[0]] == symbol &&
                cells[line[1]] == symbol &&
                cells[line[2]] == symbol) {
                return true;
            }
        }
        return false;
    }

    public boolean isFull() {
        for (char cell : cells) {
            if (cell == ' ') {
                return false;
            }
        }
        return true;
    }
}
