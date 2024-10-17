package calculator;

import calculator.input.InputHandler;

public class Application {
    public static void main(String[] args) {

        InputHandler inputHandler = new InputHandler();

        inputHandler.showMessage();

        String input = inputHandler.input();

        System.out.println("입력한 값: " + input);
    }
}
