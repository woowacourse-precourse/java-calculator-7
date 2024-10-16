package calculator;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputHandler inputHandler = new InputHandler();
        Calculator calculator = new Calculator();
        InputHandler.DelimiterType delimiterType;

        String userInput = inputHandler.getUserInput();
        System.out.println("입력: "+ userInput);
        System.out.println( "길이:"+ userInput.length());
        delimiterType = inputHandler.isValidInput(userInput);
        int[] numbers = inputHandler.stringToIntArray(userInput, delimiterType);
        int result = calculator.addition(numbers);

        System.out.println("결과 : " + Integer.toString(result));

    }
}
