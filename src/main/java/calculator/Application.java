package calculator;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        DelimiterType delimiterType;
        InputReader inputReader = new InputReader();
        InputValidator inputValidator = new InputValidator();
        InputTransformer inputTransformer = new InputTransformer();
        Calculator calculator = new Calculator();

        String userInput = inputReader.getUserInput();
        delimiterType = inputValidator.isValidInput(userInput);
        int[] numbers = inputTransformer.stringToIntArray(userInput, delimiterType);
        int result = calculator.addition(numbers);

        System.out.println("결과 : " + Integer.toString(result));

    }
}
