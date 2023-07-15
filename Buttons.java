import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/*
 * Files: Buttons.java                  
 * Author: Mohamedamin Mohamed          
 * Contact mohamedamin204080@gmail.com  
 * Created 07/10/2023                   
 * Modified: 07/11/2023                    
 * Description: This class will handle the button actions and maintain the 
state of the game.            *
 */

public class Buttons implements ActionListener{
	private JFrame frame;
	private JButton[][] buttons;
	private JLabel label;
	private int turn = 0;
	private String player = "Red";
	
   public Buttons(JFrame frame, JLabel label) {
	intializeComponents(frame, label);
   }
	private void intializeComponents(JFrame frame, JLabel label){
	this.frame = frame;
	this.label = label;
	buttons = new JButton[6][7]; //board of 6 rows & 7 columns
	   
  for(int i = 0; i < buttons.length; i++) {
	for(int j = 0; j < buttons[i].length;j++) {
	buttons[i][j] = new JButton(); //create a button at each index
	buttons[i][j].setActionCommand(i + "-" + j);//each button will have its own unique action
        buttons[i][j].addActionListener(this);//set an event listener for each button
	buttons[i][j].setOpaque(true);
			}
		}
	}

	@Override
  public void actionPerformed(ActionEvent e) {
	JButton button = (JButton) e.getSource();
  if(!button.isEnabled()) {
	JOptionPane.showMessageDialog(null, "Cell already clicked", "Cell Click", JOptionPane.INFORMATION_MESSAGE);
			return;  /*if a button is clicked a second time, then there is no reason to perform any operations, because the button is disabled*/
		}
  else {
	button.setEnabled(false); //this line will be  triggered if its the first time that the button is being clicked
	turn++;

	String[] position = e.getActionCommand().split("-");/*array will split the action string into their appropriate rows and columns*/
	int row = Integer.parseInt(position[0]);
	int col = Integer.parseInt(position[1]);
	  
	button = buttons[row][col];
	button.setBackground((player.equals("Red"))? 
        Color.red : Color.yellow);//also alternate the players color		
	player = player.equals("Red")? "Yellow" : "Red"; 
        /*alternate the players name, if its yellows turn, then set the background of the clicked button to be the current players color*/
	label.setText(player + " players turn!");

	CheckWinner winLose = new CheckWinner(buttons, row, col); 
	boolean winner = winLose.getWinner();
  
	new OutputWinner(frame, buttons, label, winner, turn, player);

        label.setFont(new Font(null, Font.BOLD, 30));	
        label.setHorizontalAlignment(SwingConstants.CENTER);
		}
	}
	
	public JButton[][] getButtons() {
		return buttons;
	}
}

