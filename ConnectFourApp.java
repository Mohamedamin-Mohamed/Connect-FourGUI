import javax.swing.SwingUtilities;

/*
 * Files: ConnectFourApp.java          
 * Author: Mohamedamin Mohamed          
 * Contact mohamedamin204080@gmail.com  
 * Created 07/10/2023                   
 * Modified: 07/16/2023              
 * Description:This class sets up the necessary components and establishes the connections between them to create a functioning App
 */
public class ConnectFourApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ConnectFourModel model = new ConnectFourModel();
            ConnectFourView view = new ConnectFourView();
            ConnectFourController controller = new ConnectFourController(model, view);
            
            view.addActionListener(controller);
        });
    }

}
