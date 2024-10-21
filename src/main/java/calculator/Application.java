package calculator;

import calculator.config.AppConfig;
import calculator.controller.CalculatorController;
import calculator.view.InputView;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        CalculatorController calculatorController = appConfig.calculatorController();
        InputView inputView = appConfig.inputView();

        calculatorController.run(inputView.getInput());
    }
}
