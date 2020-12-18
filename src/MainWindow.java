import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow implements Window {
    private Controller controller;
    private InformationWindow informationWindow;
    private ModelInputWindow modelInputWindow;
    private JButton infoButton;
    private JPanel panel1;
    private JButton modelButton;

    public MainWindow(Controller controller, InformationWindow informationWindow, ModelInputWindow modelInputWindow) {
        this.controller = controller;
        this.informationWindow = informationWindow;
        this.modelInputWindow = modelInputWindow;
        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showInfoAboutAnimals();
            }
        });
        modelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelAnimalInteractions();
            }
        });
    }

    public void showInfoAboutAnimals() {
        informationWindow.crateUI();
    }

    public void modelAnimalInteractions() {
        modelInputWindow.crateUI();
    }

    @Override
    public void crateUI() {
        JFrame frame = new JFrame();
        frame.setContentPane(panel1);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
