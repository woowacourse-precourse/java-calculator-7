package calculator.config;

import calculator.presentation.StringAdditionController;
import calculator.application.DelimiterProcessor;
import calculator.application.StringSumCalculator;
import calculator.io.InputHandler;
import calculator.io.ResultPrinter;

public class ApplicationContext {

    private final InputHandler inputHandler;
    private final DelimiterProcessor delimiterProcessor;
    private final StringSumCalculator stringSumCalculator;
    private final ResultPrinter resultPrinter;
    private final StringAdditionController stringAdditionController;

    public ApplicationContext() {
        this.inputHandler = new InputHandler();
        this.delimiterProcessor = new DelimiterProcessor();
        this.stringSumCalculator = new StringSumCalculator();
        this.resultPrinter = new ResultPrinter();

        this.stringAdditionController = new StringAdditionController(inputHandler, delimiterProcessor,
                stringSumCalculator, resultPrinter);
    }

    public StringAdditionController getStringAdditionController() {
        return stringAdditionController;
    }
}
