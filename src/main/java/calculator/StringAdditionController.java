package calculator;

public class StringAdditionController {

    private final InputHandler inputHandler;
    private final DelimiterProcessor delimiterProcessor;
    private final StringSumCalculator stringSumCalculator;
    private final ResultPrinter resultPrinter;

    public StringAdditionController(InputHandler inputHandler, DelimiterProcessor delimiterProcessor,
                                    StringSumCalculator stringSumCalculator, ResultPrinter resultPrinter) {
        this.inputHandler = inputHandler;
        this.delimiterProcessor = delimiterProcessor;
        this.stringSumCalculator = stringSumCalculator;
        this.resultPrinter = resultPrinter;
    }

    public void run() {
        String input = inputHandler.input();
        String[] stringNumbers = delimiterProcessor.extractNumberStrings(input);
        int sum = stringSumCalculator.sumStringNumbers(stringNumbers);
        resultPrinter.printResult(sum);
    }
}
