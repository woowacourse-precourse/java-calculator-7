package calculator.presentation;

import calculator.application.DelimiterProcessor;
import calculator.application.StringSumCalculator;
import calculator.io.InputHandler;
import calculator.io.ResultPrinter;
import java.util.Optional;

public class StringAdditionController {

    private final static int ZERO = 0;
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
        inputHandler.input()
                .ifPresentOrElse(
                        this::processInput,
                        () -> resultPrinter.printResult(ZERO)
                );
    }

    private void processInput(String input) {
        String[] stringNumbers = delimiterProcessor.extractNumberStrings(input);
        int sum = stringSumCalculator.sumStringNumbers(stringNumbers);
        resultPrinter.printResult(sum);
    }
}
