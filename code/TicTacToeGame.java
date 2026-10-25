
public class TicTacToeGame {
    private final GameBoard board;
    private final Player[] players;
    private int currentPlayerIndex;
    private boolean gameOver;
    private String status;

    public TicTacToeGame() {
        board = new GameBoard();
        players = new Player[] {
            new HumanPlayer("Player 1", 'X'),
            new HumanPlayer("Player 2", 'O')
        };
        reset();
    }

    public GameBoard getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return players[currentPlayerIndex];
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public String getStatus() {
        return status;
    }

    public void playMove(int position) {
        if (gameOver) {
            return;
        }

        Player player = getCurrentPlayer();
        int move = player.chooseMove(board, position);

        if (!board.placeSymbol(move, player.getSymbol())) {
            status = "That cell is already taken. Choose another cell.";
            return;
        }

        if (board.hasWinner(player.getSymbol())) {
            status = player.getName() + " (" + player.getSymbol() + ") wins!";
            gameOver = true;
        } else if (board.isFull()) {
            status = "It's a draw!";
            gameOver = true;
        } else {
            currentPlayerIndex = 1 - currentPlayerIndex;
            status = getCurrentPlayer().getName() + "'s turn (" +
                     getCurrentPlayer().getSymbol() + ")";
        }
    }

    public void reset() {
        board.reset();
        currentPlayerIndex = 0;
        gameOver = false;
        status = "Player 1's turn (X)";
    }
}
