import java.awt.Color;
import javax.swing.JButton;

/*
 * Files: ConnectFourModel.java          
 * Author: Mohamedamin Mohamed          
 * Contact mohamedamin204080@gmail.com  
 * Created 07/16/2023    
 * modified 07/16/2023               
 * Description:This class encapsulates the core functionality and logic of the Connect Four game
 */

public class ConnectFourModel {
    private JButton[][] buttons;
    private int turn;
    private String currentPlayer;

    public ConnectFourModel() {
        initialize();
    }

    public void initialize() {
        buttons = new JButton[6][7];
        turn = 0;
        currentPlayer = "Red";
        
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setActionCommand(i + "-" + j);
            }
        }
    }

    public void makeMove(int row, int col) {
        JButton button = buttons[row][col];
        button.setEnabled(false);
        button.setBackground(currentPlayer.equals("Red") ? Color.RED : Color.YELLOW);
        currentPlayer = currentPlayer.equals("Red") ? "Yellow" : "Red";
        turn++;
    }

    public boolean checkWinner(int row, int col) {
        Color currColor = buttons[row][col].getBackground();

        // Check horizontally
        for (int j = Math.max(0, col - 3); j <= col; j++) {
            if (j >= 0) {
                if (buttons[row][j].getBackground().equals(currColor)
                        && buttons[row][j + 1].getBackground().equals(currColor)
                        && buttons[row][j + 2].getBackground().equals(currColor)
                        && buttons[row][j + 3].getBackground().equals(currColor)) {
                    return true;
                }
            }
        }

        // Check vertically
        for (int i = Math.max(0, row - 3); i <= row; i++) {
            if (buttons[i][col].getBackground().equals(currColor)
                    && buttons[i + 1][col].getBackground().equals(currColor)
                    && buttons[i + 2][col].getBackground().equals(currColor)
                    && buttons[i + 3][col].getBackground().equals(currColor)) {
                return true;
            }
        }

        // Check diagonal (down-right)
        for (int i = Math.max(0, row - 3), j = Math.max(0, col - 3); i <= row; i++, j++) {
            if (i >= 0 && j >= 0) {
                if (buttons[i][j].getBackground().equals(currColor)
                        && buttons[i + 1][j + 1].getBackground().equals(currColor)
                        && buttons[i + 2][j + 2].getBackground().equals(currColor)
                        && buttons[i + 3][j + 3].getBackground().equals(currColor)) {
                    return true;
                }
            }
        }

        // Check diagonal (up-right)
        for (int i = row, j = col; i >= row - 3 && j <= col + 3; i--, j++) {
            if (i - 3 >= 0 && j + 3 < 7) {
                if (buttons[i][j].getBackground().equals(currColor)
                        && buttons[i - 1][j + 1].getBackground().equals(currColor)
                        && buttons[i - 2][j + 2].getBackground().equals(currColor)
                        && buttons[i - 3][j + 3].getBackground().equals(currColor)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isBoardFull() {
        return turn == 42;
    }

    public JButton[][] getButtons() {
        return buttons;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

}
