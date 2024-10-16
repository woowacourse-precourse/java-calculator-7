package calculator;

import calculator.adder.Adder;
import calculator.inputhandler.InputHandler;
import java.math.BigInteger;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        String input = inputHandler.getInput("덧셈할 문자열을 입력해주세요.\n");

        Adder adder = new Adder();
        BigInteger sum = adder.addInput(input);
    }

}
