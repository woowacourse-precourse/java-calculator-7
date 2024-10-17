package calculator;

import calculator.domain.CharExtractor;
import calculator.input.InputHandler;

public class Application {
    public static void main(String[] args) {

        InputHandler inputHandler = new InputHandler();
        inputHandler.showMessage();
        String input = inputHandler.input();

        CharExtractor charExtractor = new CharExtractor(input);

        while (charExtractor.hasNext()) {
            Character currentChar = charExtractor.nextChar();
            System.out.println("현재 문자: " + currentChar);
        }

    }
}
