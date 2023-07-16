import javax.swing.SwingUtilities;;
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
