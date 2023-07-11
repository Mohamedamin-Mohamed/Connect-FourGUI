import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Connect_FourGUI extends JFrame implements ActionListener{

	private JButton[][] buttons;
	private JLabel label;
	private String player = "Red";
	private int turn = 0;

	Connect_FourGUI(){
		setTitle("Connect Four GUI App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,200);
		setLayout(new BorderLayout());
		setVisible(true);
		pack();

		label = new JLabel(player + " players turn!");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font(null, Font.BOLD, 30));
		add(label, BorderLayout.NORTH);
		buttons = new JButton[6][7];//board of 6 rows & 7 columns
		for(int i = 0; i < buttons.length; i++) {
			for(int j = 0; j < buttons[i].length;j++) {
				buttons[i][j] = new JButton();//create a 
button at each position
				buttons[i][j].setActionCommand(i + "-" + 
j);//each button will have its own unique action
				
buttons[i][j].addActionListener(this);//set an event listener for each 
button
				buttons[i][j].setOpaque(true);
			}
		}

		//we'll use the panel as out board, which will have 6 rows 
& 7 columns
		JPanel panel = new JPanel(new GridLayout(6, 7));
		//panel.setBackground(new Color(176, 224, 230));
		for(int i = 0; i < buttons.length; i++) {
			for(int j = 0; j < buttons[i].length;j++) {
				panel.add(buttons[i][j]);
			}
		}
		//panel.add(label);
		add(panel, BorderLayout.CENTER);
	}
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		if(!button.isEnabled()) return;//the second a button is 
clicked, then there is no reason to perform any operations,
		// because the button is disabled
		
		String[] position = e.getActionCommand().split("-");
		int row = Integer.parseInt(position[0]);
		int col = Integer.parseInt(position[1]);


		button = buttons[row][col];
		Color color = button.getBackground();
		
		boolean winner = checkWinner(buttons, color, turn);

		if(winner) {
			JOptionPane.showMessageDialog(null, player + " 
player wins, Game Over", "Game stats", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if(turn == 42) {
			JOptionPane.showMessageDialog(null, "Game is draw, 
Game Over", "Game stats", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		button.setEnabled(false);//this line will be triggered if 
its the first time that the button is being clicked,
		turn++;
		player = player.equals("Red")? "Yellow" : "Red"; 
//alternate the players name
		//its yellows turn set the background of the clicked 
button to be the current players color

		button.setBackground((player.equals("Red"))? Color.yellow 
: Color.red);//also alternate the players color, if red was playing then,
		label.setText(player + " players turn!");
		
		label.setFont(new Font(null, Font.BOLD, 30));
		label.setHorizontalAlignment(SwingConstants.CENTER);

	}
	public boolean checkWinner(JButton[][] buttons, Color currColor, 
int turn) {
		//check winner horizontal
		for(int i = 0; i < 6; i++) {//loop 6 times because going 
vertically you have to check each row
			for(int j =0; j < 4; j++) {//loop 4 times because 
going horizontally you can make a combination of 4 cells only 4 times
				
if(buttons[i][j].getBackground().equals(currColor) && buttons[i][j + 
1].getBackground().equals(currColor) 
						&& buttons[i][j + 
2].getBackground().equals(currColor) && buttons[i][j + 
3].getBackground().equals(currColor))
					return true;
			}
		}
		//check winner vertically
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 7; j++) {
				
if(buttons[i][j].getBackground().equals(currColor) && buttons[i + 
1][j].getBackground().equals(currColor) 
						&& buttons[i + 
2][j].getBackground().equals(currColor) && buttons[i + 
3][j].getBackground().equals(currColor))
					return true;
			}
		}
		//check for diagonal going down
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 4; j++) {
				
if(buttons[i][j].getBackground().equals(currColor) && buttons[i + 1][j + 
1].getBackground().equals(currColor) 
						&& buttons[i + 2][j + 
2].getBackground().equals(currColor) && buttons[i + 3][j + 
3].getBackground().equals(currColor))
					return true;
			}
		}
		//check for diagonal going up
		for(int i = 3; i < 6; i++) {
			for(int j = 0; j < 4; j++) {
				
if(buttons[i][j].getBackground().equals(currColor) && buttons[i - 1][j + 
1].getBackground().equals(currColor) 
						&& buttons[i - 2][j + 
2].getBackground().equals(currColor) && buttons[i - 3][j + 
3].getBackground().equals(currColor))
					return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new Connect_FourGUI();
		});
	}
}

