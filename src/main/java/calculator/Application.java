package calculator;

import calculator.config.AppConfig;
import calculator.service.CalculatorService;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        CalculatorService calculatorService = new CalculatorService(appConfig.stringCalculator(), appConfig.ioService());

        calculatorService.run();
    }
}
