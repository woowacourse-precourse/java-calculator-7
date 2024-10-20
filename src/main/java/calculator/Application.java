package calculator;

import calculator.config.AppConfig;
import calculator.domain.Calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AppConfig appConfig = new AppConfig();
        Calculator calculator = appConfig.calculator();
        calculator.start();
    }
}
