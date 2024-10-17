package calculator;

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
