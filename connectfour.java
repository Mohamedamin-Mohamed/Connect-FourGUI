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
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Connect_FourGUI extends JFrame implements ActionListener{
	
	private JButton[][] buttons;
	private JLabel label;
	private String player = "Red";
	
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
			buttons[i][j] = new JButton();//create a button at 
each position
			buttons[i][j].setActionCommand(i + "-" + j);//each 
button will have its own unique action
			buttons[i][j].addActionListener(this);//set an 
event listener for each button
			buttons[i][j].setOpaque(true);
		}
	}
	
	//we'll use the panel as out board, which will have 6 rows & 7 
columns
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
		String[] position = e.getActionCommand().split("-");
		int row = Integer.parseInt(position[0]);
		int col = Integer.parseInt(position[1]);
		System.out.println("Row" + row + "Col" + col);
		player = player.equals("Red")? "Yellow" : "Red"; 
//alternate the players name
		JButton button = buttons[row][col];
		
		button.setBackground((player.equals("Red"))? Color.red : 
Color.yellow);//also alternate the players color, if red was playing then,
		//its yellows turn set the background of the clicked 
button to be the current players color
		label.setText(player + " players turn!");
		label.setFont(new Font(null, Font.BOLD, 30));
		label.setHorizontalAlignment(60);
		
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
            new Connect_FourGUI();
        });
	}
}

