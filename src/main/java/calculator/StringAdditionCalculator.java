package calculator;

public class StringAdditionCalculator {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public StringAdditionCalculator(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void run() {
        String input = inputHandler.readStringNumbers();
        Delimiter delimiter = DelimiterExtractor.extract(input);
        NumberParser numberParser = NumberParser.from(delimiter);
        Numbers numbers = numberParser.parse(input);
        Number sumResult = Calculator.calculateSum(numbers);
        outputHandler.printCalculationResult(sumResult.value());
        inputHandler.closeConsole();
    }
}
