package calculator;

import calculator.io.InputHandler;
import calculator.io.OutputHandler;
import java.util.Arrays;

public class Calculator {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private String delimiter;

    public Calculator(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        delimiter = "[,;]";
    }

    public void run() {
        String userInput = inputHandler.getUserInput();
        String parsedInput = extractCustomDelimiter(userInput);

        String[] inputStringNumbers = splitUserInput(parsedInput, delimiter);
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

    private String[] splitUserInput(String userInput, String delimiter) {
        return userInput.split(delimiter);
    }

    private String extractCustomDelimiter(String userInput) {
        if (hasCustomDelimiterIn(userInput)) {
            delimiter = "" + userInput.charAt(2);
            return userInput.substring(5);
        }
        return userInput;
    }

    private boolean hasCustomDelimiterIn(String userInput) {
        return userInput.startsWith("//") && userInput.startsWith("/n", 3);
    }
}
