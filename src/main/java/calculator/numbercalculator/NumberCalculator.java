package calculator.numbercalculator;

import calculator.numbercalculator.io.InputHandler;
import calculator.numbercalculator.io.OutputHandler;
import calculator.numbercalculator.number.Numbers;
import java.math.BigInteger;

public class NumberCalculator {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final NumberExtractor numberExtractor;

    public NumberCalculator(InputHandler inputHandler, OutputHandler outputHandler, NumberExtractor numberExtractor) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.numberExtractor = numberExtractor;
    }

    public void run() {
        String userInput = inputHandler.getUserInput();
        Numbers numbers = numberExtractor.extractNumbers(userInput);
        BigInteger result = numbers.calculateTotalValue();
        outputHandler.showCalculateResult(result);
    }
}
