import javax.swing.*;

public class InformationWindow implements Window {
    private Controller controller;
    private JPanel panel1;
    private JTextArea textArea1;

    public InformationWindow(Controller controller) {
        this.controller = controller;
        textArea1.setLineWrap(true);
        textArea1.setText(controller.info.information);
    }

    @Override
    public void crateUI() {
        JFrame frame = new JFrame();
        frame.setContentPane(panel1);
        frame.setSize(420, 320);
        frame.setVisible(true);
    }
}
