package calculator;

import calculator.controller.CalculatorController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AppConfig appConfig = new AppConfig();
        CalculatorController controller = appConfig.calculatorController();
        controller.run();
    }
}
