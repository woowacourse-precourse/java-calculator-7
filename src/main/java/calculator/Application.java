package calculator;

import calculator.infra.controller.MainController;

public class Application {
    public static void main(String[] args) {
        MainController mainController = MainController.initiate();
        mainController.runCalculator();
    }
}
