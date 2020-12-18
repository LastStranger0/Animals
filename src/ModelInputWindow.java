import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ModelInputWindow implements Window {
    private Controller controller;
    private ModelResultsWindow modelResultsWindow;
    private JTextField mousePopulation;
    private JPanel panel1;
    private JTextField snakePopulation;
    private JTextField hawkPopulation;
    private JTextField strengthOfDisease;
    private JTextField strengthOfDrought;
    private JTextField time;
    private JButton doButton;

    public ModelInputWindow(Controller controller, ModelResultsWindow modelResultsWindow) {
        this.controller = controller;
        this.modelResultsWindow = modelResultsWindow;
        doButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!snakePopulation.equals("") && !hawkPopulation.equals("") &&
                        !strengthOfDisease.equals("") && !strengthOfDrought.equals("") &&
                        !time.equals("")) {
                    controller.animals.clear();
                    int populationOfMouses = Integer.parseInt(mousePopulation.getText());
                    int populationOfSnakes = Integer.parseInt(snakePopulation.getText());
                    int populationOfHawks = Integer.parseInt(hawkPopulation.getText());
                    Pressure pressure = new Pressure();
                    Disease disease = new Disease();
                    pressure.strength = Integer.parseInt(strengthOfDrought.getText());
                    disease.strength = Integer.parseInt(strengthOfDisease.getText());
                    controller.natureFactors.add(pressure);
                    controller.natureFactors.add(disease);
                    controller.timeUnit = Integer.parseInt(time.getText());

                    List<Animal> mouses = new ArrayList<>();
                    List<Animal> snakes = new ArrayList<>();
                    List<Animal> hawks = new ArrayList<>();
                    List<Animal> mousesBorn = new ArrayList<>();
                    List<Animal> mousesDied = new ArrayList<>();
                    List<Animal> snakesBorn = new ArrayList<>();
                    List<Animal> snakesDied = new ArrayList<>();
                    List<Animal> hawkBorn = new ArrayList<>();
                    List<Animal> hawkDied = new ArrayList<>();

                    for (int i = 0; i < populationOfMouses; i++) {
                        Rabbit rabbit = new Rabbit();
                        mouses.add(rabbit);
                        controller.animals.add(rabbit);
                    }
                    for (int i = 0; i < populationOfSnakes; i++) {
                        Snake snake = new Snake();
                        snakes.add(snake);
                        controller.animals.add(snake);
                    }
                    for (int i = 0; i < populationOfHawks; i++) {
                        SnakeEater snakeEater = new SnakeEater();
                        hawks.add(snakeEater);
                        controller.animals.add(snakeEater);
                    }

                    for (int curTime = 0; curTime < controller.timeUnit; curTime++) {
                        for (Animal animal : mouses) {
                            if (mouses.indexOf(animal) % 2 == 0) {
                                for (int i = 0; i < animal.cubsPerYear; i++)
                                    mousesBorn.add(new Rabbit());
                            }

                            if (Math.random() * (100 + disease.strength) % 100 > 1) {
                                mousesDied.add(animal);
                                continue;
                            }

                            if (Math.random() * (100 + pressure.strength) % 100 > 1) {
                                mousesDied.add(animal);
                                continue;
                            }

                            animal.age += 12;
                            if (animal.age >= animal.lifeSpan) {
                                mousesDied.add(animal);
                            }
                        }
                        for (Animal animal : snakes) {
                            if (snakes.indexOf(animal) % 2 == 0) {
                                for (int i = 0; i < animal.cubsPerYear; i++)
                                    snakesBorn.add(new Rabbit());
                            }

                            if (Math.random() * (100 + disease.strength) % 100 > 1) {
                                snakesDied.add(animal);
                                continue;
                            }

                            animal.age += 12;
                            if (animal.age >= animal.lifeSpan) {
                                snakesDied.add(animal);
                            }
                        }

                        for (Animal animal : hawks) {
                            if (hawks.indexOf(animal) % 2 == 0) {
                                for (int i = 0; i < animal.cubsPerYear; i++)
                                    hawkBorn.add(new Rabbit());
                            }

                            if (Math.random() * (100 + disease.strength) % 100 > 1) {
                                hawkDied.add(animal);
                                continue;
                            }

                            animal.age += 12;
                            if (animal.age >= animal.lifeSpan) {
                                hawkDied.add(animal);
                            }
                        }

                        mouses.removeAll(mousesDied);
                        mouses.addAll(mousesBorn);

                        snakes.removeAll(snakesDied);
                        snakes.addAll(snakesBorn);

                        hawks.removeAll(hawkDied);
                        hawks.addAll(hawkBorn);

                        controller.result = "Время взаимодействия: " + controller.timeUnit + " года\n\n" +
                                "Мышей умерло: " + mousesDied.size() + "\n" +
                                "Мышей родилось: " + mousesBorn.size() + "\n" +
                                "Текущая популяция: " + mouses.size() + "\n\n" +
                                "Змей умерло: " + snakesDied.size() + "\n" +
                                "Змей родилось: " + snakesBorn.size() + "\n" +
                                "Текущая популяция: " + snakes.size() + "\n\n" +
                                "Ястребов умерло: " + hawkDied.size() + "\n" +
                                "Ястребов родилось: " + hawkBorn.size() + "\n" +
                                "Текущая популяция: " + hawks.size();

                        controller.animals.clear();
                        controller.animals.addAll(mouses);
                        controller.animals.addAll(snakes);
                        controller.animals.addAll(hawks);
                    }
                    modelResultsWindow.crateUI();
                }
            }
        });
    }

    @Override
    public void crateUI() {
        JFrame frame = new JFrame();
        frame.setContentPane(panel1);
        frame.pack();
        frame.setVisible(true);
    }
}
