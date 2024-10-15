package calculator;

import calculator.infrastructure.config.AppConfig;
import calculator.presentation.CalculationUseCase;

public class Application {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        CalculationUseCase calculationUseCase = appConfig.calculationUseCase();
        calculationUseCase.handleCalculation();
    }
}
