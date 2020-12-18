import javax.swing.*;

public class ModelResultsWindow implements Window {
    private Controller controller;
    private JPanel panel1;
    private JTextArea textArea1;
    private JButton exitButton;
    private JButton continueButton;

    public ModelResultsWindow(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void crateUI() {
        controller.getPopulation();
        textArea1.setText(controller.result);
        textArea1.setLineWrap(true);
        JFrame frame = new JFrame();
        frame.setContentPane(panel1);
        frame.pack();
        frame.setVisible(true);
    }
}
