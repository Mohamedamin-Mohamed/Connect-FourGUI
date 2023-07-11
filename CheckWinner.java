import java.awt.Color;
import javax.swing.JButton;

/*
 * Files: Connect_FourGUI.java          
 * Author: Mohamedamin Mohamed          
 * Contact mohamedamin204080@gmail.com  
 * Created 07/10/2023                   
 * Description:This class handles the logic for checking if a player has 
won the game.             
 */

public class CheckWinner {
	private JButton[][] buttons;
	private int row;
	private int col;
	private boolean winner;
	
	CheckWinner(JButton[][] buttons, int row, int col){
		this.buttons = buttons;
		this.row = row;
		this.col = col;
		this.winner = checkWinner();
	}
	
	public boolean checkWinner() {
		Color currColor = buttons[row][col].getBackground(); 
//background color of current index will be returned

		// Check horizontally
		for (int j = col - 3; j <= col; j++) {
			if (j >= 0 && j + 3 < 7) {
				if 
(buttons[row][j].getBackground().equals(currColor)
						&& buttons[row][j + 
1].getBackground().equals(currColor)
						&& buttons[row][j + 
2].getBackground().equals(currColor)
						&& buttons[row][j + 
3].getBackground().equals(currColor)) {
					return true;
				}
			}
		}

		// Check vertically
		for (int i = row - 3; i <= row; i++) {
			if (i >= 0 && i + 3 < 6) {
				if 
(buttons[i][col].getBackground().equals(currColor)
						&& buttons[i + 
1][col].getBackground().equals(currColor)
						&& buttons[i + 
2][col].getBackground().equals(currColor)
						&& buttons[i + 
3][col].getBackground().equals(currColor)) {
					return true;
				}
			}
		}

		// Check diagonal (down-right)
		for (int i = row - 3, j = col - 3; i <= row && j <= col; 
i++, j++) {
			if (i >= 0 && i + 3 < 6 && j >= 0 && j + 3 < 7) {
				if 
(buttons[i][j].getBackground().equals(currColor)
						&& buttons[i + 1][j + 
1].getBackground().equals(currColor)
						&& buttons[i + 2][j + 
2].getBackground().equals(currColor)
						&& buttons[i + 3][j + 
3].getBackground().equals(currColor)) {
					return true;
				}
			}
		}

		// Check diagonal (up-right)
		for (int i = row + 3, j = col - 3; i >= row && j <= col; 
i--, j++) {
			if (i >= 0 && i - 3 < 6 && j >= 0 && j + 3 < 7) {
				if 
(buttons[i][j].getBackground().equals(currColor)
						&& buttons[i - 1][j + 
1].getBackground().equals(currColor)
						&& buttons[i - 2][j + 
2].getBackground().equals(currColor)
						&& buttons[i - 3][j + 
3].getBackground().equals(currColor)) {
					return true;
				}
			}
		}

		return false;
	}
	public boolean getWinner() {
		return winner;
	}
}

