package calculator;

import java.nio.charset.StandardCharsets;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputHandler inputHandler = new InputHandler();
        Calculator calculator = new Calculator();
        String userInput = inputHandler.getInput();
        System.out.println(calculator.calculate(userInput));
    }
}
