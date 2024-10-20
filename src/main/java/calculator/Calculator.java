package calculator;

import calculator.view.InputHandler;
import calculator.view.OutputHandler;
import java.util.Arrays;

public class Calculator {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public Calculator(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void run() {
        DelimiterParser delimiterParser = new DelimiterParser();
        String userInput = inputHandler.getUserInput();
        String delimiter = delimiterParser.extractDelimiter(userInput);
        String extractedInput = delimiterParser.extractExpression(userInput);

        String[] inputStringNumbers = parseUserInput(extractedInput, delimiter);
        int[] inputIntegerNumbers = changeStringArrayToIntegerArray(inputStringNumbers);
        int result = sumAllNumbers(inputIntegerNumbers);
        outputHandler.printMessage(String.valueOf(result));
    }

    private int sumAllNumbers(int[] inputIntegerNumbers) {
        return Arrays.stream(inputIntegerNumbers).sum();
    }

    private int[] changeStringArrayToIntegerArray(String[] StringNumbers) {
        return Arrays.stream(StringNumbers)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private String[] parseUserInput(String userInput, String delimiter) {
        return userInput.split(delimiter);
    }
}
