package calculator;

import calculator.io.InputHandler;
import java.util.Arrays;

public class Calculator {
    private final InputHandler inputHandler;

    public Calculator(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public void run() {
        String userInput = inputHandler.getUserInput();

        String[] inputStringNumbers = splitUserInput(userInput, "[,;]");
        int[] inputIntegerNumbers = changeStringArrayToIntegerArray(inputStringNumbers);
        int result = sumAllNumbers(inputIntegerNumbers);
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
}
