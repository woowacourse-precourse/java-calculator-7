package calculator;

import calculator.application.usecase.CalculateStringUseCase;
import calculator.config.AppConfig;

public class Application {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        CalculateStringUseCase calculateStringUseCase = appConfig.getCalculateStringUseCase();

        calculateStringUseCase.calculate();
    }
}
