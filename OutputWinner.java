import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/*
 * Files: Connect_FourGUI.java          
 * Author: Mohamedamin Mohamed          
 * Contact mohamedamin204080@gmail.com  
 * Created 07/10/2023                   
 * Modified: 07/11/2023                 
 * Description:This class handles the logic for displaying the winner or a 
draw message.           
 */

public class OutputWinner {
	private JFrame frame;
	private JButton[][] buttons;
	private JLabel label;
	private boolean winner;
	private int turn;
	private String player;

	public OutputWinner(JFrame frame, JButton[][] buttons, JLabel label, boolean winner, int turn, String player){
		this.frame = frame;
		this.buttons = buttons;
		this.label = label;
		this.winner = winner;
		this.turn = turn;
		this.player = player;
		outputWinner();
	}

	public void outputWinner() {
		if(winner) {
			player = player.equals("Red")? "Yellow" : "Red"; //alternate the players name
			label.setText(player + " wins!");
			
			//0 will be returned if player wants to play again and 1 if vice versa
			int returnCode = JOptionPane.showConfirmDialog(null, player + " player wins, Game Over. Want to play again", "Game stats", JOptionPane.YES_NO_OPTION);
			if (returnCode == JOptionPane.YES_OPTION) 
				resetBoard();
			else 
				closeFrame(); //close the frame if user doesn't want to play again
		}

		else if(turn == 42) {
			JOptionPane.showMessageDialog(null, "Game is draw, Game Over", "Game stats", JOptionPane.INFORMATION_MESSAGE);
			closeFrame(); //lets close the frame even if the game is draw
			return;
		}
	}
	private void resetBoard() { //new board will be created
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				buttons[i][j].setEnabled(true);
				buttons[i][j].setBackground(null);
			}
		}
		turn = 0; //since we are starting a new game, we rest turn to 0
		player = "Red"; //just like we did when we created the frame, we'll let red player start the game
		frame.setTitle("Connect Four GUI App");
	}
	private void closeFrame() {
		frame.dispose();
	}
}

