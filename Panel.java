import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * Files: Connect_FourGUI.java          
 * Author: Mohamedamin Mohamed          
 * Contact mohamedamin204080@gmail.com  
 * Created 07/10/2023                   
 * Modified: 07/11/2023              
 * Description:This class represents the game board panel.
 */
public class Panel{
	private JPanel panel;
	
	Panel(JButton[][] buttons){
		//we'll use the panel as out board, which will have 6 rows 
& 7 columns
		panel = new JPanel(new GridLayout(6, 7));
		
		for(int i = 0; i < buttons.length; i++) {
			for(int j = 0; j < buttons[i].length;j++) {
				panel.add(buttons[i][j]);
			}
		}
	}
	public JPanel getPanel() {
		return panel; //the board will be returned, example is so 
as to be added to the frame
	}
}

