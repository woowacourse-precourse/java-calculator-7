package calculator.numbercalculator;

import calculator.numbercalculator.io.InputHandler;
import calculator.numbercalculator.io.OutputHandler;
import calculator.numbercalculator.number.Numbers;
import java.math.BigInteger;
import java.util.List;

public class NumberCalculator {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final DelimiterProcessor delimiterProcessor;

    public NumberCalculator(InputHandler inputHandler, OutputHandler outputHandler,
                            DelimiterProcessor delimiterProcessor) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.delimiterProcessor = delimiterProcessor;
    }

    public void run() {
        String inputString = getInputStringFromUser();
        Numbers numbers = extractNumbers(inputString);
        BigInteger result = numbers.calculateTotalValue();
        outputHandler.showCalculateResult(result);
    }

    private String getInputStringFromUser() {
        outputHandler.showAdditionComment();
        return inputHandler.getUserInput();
    }

    private Numbers extractNumbers(String inputString) {
        List<String> processedStrings = delimiterProcessor.process(inputString);
        return Numbers.of(processedStrings);
    }
}
