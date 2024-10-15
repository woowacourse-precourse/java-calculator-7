package calculator;

import calculator.config.AppConfig;
import calculator.adapters.input.cli.CliCalculationController;

public class Application {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        CliCalculationController cliCalculationController = appConfig.cliCalculationController();
        cliCalculationController.handle();
    }
}
