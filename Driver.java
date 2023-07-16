import javax.swing.SwingUtilities;

/* 
 * Files: Driver.java          
 * Author: Mohamedamin Mohamed          
 * Contact mohamedamin204080@gmail.com  
 * Created 07/10/2023    
 * modified 07/16/2023               
 * Description:This class sets up the main application window
 */
public class Driver {
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(()->{;
		new Connect_FourGUI();
		});
	}

}

