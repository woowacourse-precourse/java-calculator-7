package calculator;

import calculator.Calculator.CalculatorService;
import calculator.IO.InputService;
import calculator.IO.OutputService;

public class AppConfig {
    private static final AppConfig appConfig = new AppConfig();
    private InputService inputService;
    private OutputService outputService;
    private CalculatorService calculatorService;

    private AppConfig() {}

    public static AppConfig getInstance() {
        return appConfig;
    }

    public InputService getInputService() {
        if (inputService == null)
            inputService = new InputService();

        return inputService;
    }

    public OutputService getOutputService() {
        if (outputService == null)
            outputService = new OutputService();

        return outputService;
    }

    public CalculatorService getCalculatorService() {
        if (calculatorService == null)
            calculatorService = new CalculatorService();

        return calculatorService;
    }
}
