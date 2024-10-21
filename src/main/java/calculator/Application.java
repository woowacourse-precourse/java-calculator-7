package calculator;

import calculator.controller.CalculatorController;
import java.util.Locale;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig(Locale.KOREA);
        CalculatorController calculatorController = appConfig.calculatorController();
        calculatorController.run();
    }
}
