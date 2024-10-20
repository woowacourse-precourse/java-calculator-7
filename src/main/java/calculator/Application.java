package calculator;

import calculator.adder.Adder;
import calculator.inputhandler.InputHandler;
import calculator.outputhandler.OutputHandler;
import java.math.BigInteger;

public class Application {
    public static void main(String[] args) {
        String input = InputHandler.getInput("덧셈할 문자열을 입력해 주세요.\n");

        Adder adder = new Adder();
        BigInteger sum = adder.addInput(input);

        OutputHandler.printResult("결과 : ", sum.toString());
    }

}
