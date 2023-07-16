import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/*
 * Files: ConnectController.java          
 * Author: Mohamedamin Mohamed          
 * Contact mohamedamin204080@gmail.com  
 * Created 07/16/2023                   
 * Modified: 07/16/2023                 
 * Description:This class is responsible for handling user interactions 
 * and updating the model accordingly.             
 */  
public class ConnectFourController implements ActionListener{
    private ConnectFourModel model;
    private ConnectFourView view;

    public ConnectFourController(ConnectFourModel model, ConnectFourView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String actionCommand = button.getActionCommand();
        String[] position = actionCommand.split("-");
        int row = Integer.parseInt(position[0]);
        int col = Integer.parseInt(position[1]);

        if (!button.isEnabled()) {
            JOptionPane.showMessageDialog(null, "Cell already clicked", "Cell Click", JOptionPane.INFORMATION_MESSAGE);
        } else {
            model.makeMove(row, col);

            if (model.checkWinner(row, col)) {
                String currentPlayer = model.getCurrentPlayer();
                JOptionPane.showMessageDialog(null, currentPlayer + " player wins, Game Over", "Game stats", JOptionPane.INFORMATION_MESSAGE);
                model.initialize();
            } else if (model.isBoardFull()) {
                JOptionPane.showMessageDialog(null, "Game is a draw, Game Over", "Game stats", JOptionPane.INFORMATION_MESSAGE);
                model.initialize();
            }

            view.updateView(model);
        }
    }
}
