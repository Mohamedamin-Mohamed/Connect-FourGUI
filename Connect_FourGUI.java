// Connect_FourGUI.java
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/*********************************************************
 * Files: Connect_FourGUI.java          
 * Author: Mohamedamin Mohamed          
 * Contact mohamedamin204080@gmail.com  
 * Created 07/10/2023                   
 * Modified: 07/14/2023                 
 * Description:This program builds a connect four" simulator!
 * This class represents the main application window. 
 * It will create the JFrame and set up the UI components.             
 **********************************************************/                                   

public class Connect_FourGUI {
	private JFrame frame;
	private JLabel label;
	private Buttons buttons;

	Connect_FourGUI() {
		frame = new JFrame("Connect Four GUI App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		label = new JLabel("Red player's turn!");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font(null, Font.BOLD, 30));
		frame.add(label, BorderLayout.NORTH);

		buttons = new Buttons(frame, label);
		Panel panel = new Panel(buttons.getButtons());
		frame.add(panel.getPanel(), BorderLayout.CENTER);

		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}

