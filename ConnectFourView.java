import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ConnectFourView {
    private JFrame frame;
    private JLabel label;
    private JButton[][] buttons;

    public ConnectFourView() {
        frame = new JFrame("Connect Four GUI App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        label = new JLabel("Red player's turn!");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font(null, Font.BOLD, 30));
        frame.add(label, BorderLayout.NORTH);

        buttons = new JButton[6][7];
        JPanel panel = new JPanel(new GridLayout(6, 7));
        
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j] = new JButton();
                panel.add(buttons[i][j]);
            }
        }
        
        frame.add(panel, BorderLayout.CENTER);

        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void addActionListener(ActionListener listener) {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j].addActionListener(listener);
            }
        }
    }

    public void updateView(ConnectFourModel model) {
        String currentPlayer = model.getCurrentPlayer();
        label.setText(currentPlayer + " player's turn!");
    }
}
