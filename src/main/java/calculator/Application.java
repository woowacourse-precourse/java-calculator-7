package calculator;

import calculator.adapters.input.cli.CliInputAdapter;
import calculator.application.usecase.CalculateStringUseCase;
import calculator.infrastructure.config.AppConfig;
import calculator.port.input.InputPort;

public class Application {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        CliInputAdapter cliInputAdapter = appConfig.getCliInputAdapter();
        cliInputAdapter.run();
    }
}
