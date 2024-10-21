package calculator;

import calculator.controller.ConsoleController;
import calculator.controller.UserController;

public class Application {
    public static void main(String[] args) {
        // TODO
        AppConfig appConfig = new AppConfig();
        UserController userController = appConfig.userController();
        userController.run();
    }
}
