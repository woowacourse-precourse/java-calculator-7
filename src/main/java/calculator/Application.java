package calculator;

import calculator.adapters.input.cli.CliInputAdapter;
import calculator.infrastructure.config.AppConfig;

public class Application {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        CliInputAdapter cliInputAdapter = appConfig.getCliInputAdapter();
        cliInputAdapter.run();
    }
}
