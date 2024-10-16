package calculator;

import calculator.delimiter.Delimiter;
import calculator.inputhandler.InputHandler;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        String input = inputHandler.getInput("덧셈할 문자열을 입력해주세요.\n");

        Delimiter delimiter = new Delimiter();
        if (input.startsWith("//")) {
            input = delimiter.addCustomDelimiter(input);
        }
    }

}
