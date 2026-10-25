import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 * Swing graphical user interface for Tic-Tac-Toe.
 */
public class TicTacToeGUI extends JFrame {
    private final TicTacToeGame game;
    private final JButton[] cells = new JButton[9];
    private final JLabel statusLabel;

    public TicTacToeGUI() {
        super("Tic-Tac-Toe");
        game = new TicTacToeGame();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JLabel title = new JLabel("TIC-TAC-TOE", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setBorder(BorderFactory.createEmptyBorder(15, 5, 5, 5));
        add(title, BorderLayout.NORTH);

        JPanel boardPanel = new JPanel(new GridLayout(3, 3, 6, 6));
        boardPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        boardPanel.setBackground(new Color(220, 225, 235));

        for (int i = 0; i < cells.length; i++) {
            final int position = i;
            JButton button = new JButton("");
            button.setFont(new Font("Arial", Font.BOLD, 48));
            button.setFocusPainted(false);
            button.setBackground(Color.WHITE);
            button.addActionListener(event -> makeMove(position));
            cells[i] = button;
            boardPanel.add(button);
        }
        add(boardPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout(5, 5));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 15, 20));

        statusLabel = new JLabel(game.getStatus(), SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        bottomPanel.add(statusLabel, BorderLayout.CENTER);

        JButton resetButton = new JButton("New Game");
        resetButton.setFont(new Font("Arial", Font.BOLD, 15));
        resetButton.addActionListener(event -> resetGame());
        bottomPanel.add(resetButton, BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void makeMove(int position) {
        if (game.isGameOver() || game.getBoard().getCell(position) != ' ') {
            return;
        }

        char symbol = game.getCurrentPlayer().getSymbol();
        game.playMove(position);
        cells[position].setText(String.valueOf(symbol));
        cells[position].setForeground(symbol == 'X'
                ? new Color(35, 95, 190)
                : new Color(210, 70, 70));
        statusLabel.setText(game.getStatus());

        if (game.isGameOver()) {
            JOptionPane.showMessageDialog(this, game.getStatus(),
                    "Game Over", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void resetGame() {
        game.reset();
        for (JButton cell : cells) {
            cell.setText("");
            cell.setForeground(Color.BLACK);
            cell.setEnabled(true);
        }
        statusLabel.setText(game.getStatus());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TicTacToeGUI window = new TicTacToeGUI();
            window.setVisible(true);
        });
    }
}
