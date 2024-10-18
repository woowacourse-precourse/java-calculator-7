package calculator;

import calculator.global.config.AppConfig;

public class Application {

    public static void main(String[] args) {
        Application.run();
    }

    public static void run() {
        AppConfig appConfig = new AppConfig();
        appConfig.getCalculatorController().stringAdditionCalculate();
    }

}
