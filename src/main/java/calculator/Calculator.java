package calculator;

import calculator.extractor.NumberExtractor;
import calculator.io.InputHandler;
import calculator.io.OutputHandler;
import calculator.number.Numbers;

public class Calculator {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final NumberExtractor numberExtractor;

    public Calculator(InputHandler inputHandler, OutputHandler outputHandler, NumberExtractor numberExtractor) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.numberExtractor = numberExtractor;
    }

    public void run() {
        String userInput = inputHandler.getUserInput();

        Numbers numbers = numberExtractor.extractNumbers(userInput);

        int result = numbers.calculateTotalValue();

        outputHandler.showCalculateResult(result);
    }
}
