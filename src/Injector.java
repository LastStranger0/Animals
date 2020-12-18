public class Injector {
    public Window[] getAllWindows() {
        return null;
    }

    public Injector() {
        Controller controller = new Controller();
        ModelResultsWindow modelResultsWindow = new ModelResultsWindow(controller);
        InformationWindow informationWindow = new InformationWindow(controller);
        ModelInputWindow modelInputWindow = new ModelInputWindow(controller, modelResultsWindow);
        MainWindow mainWindow = new MainWindow(controller, informationWindow, modelInputWindow);
        mainWindow.crateUI();

    }
}
