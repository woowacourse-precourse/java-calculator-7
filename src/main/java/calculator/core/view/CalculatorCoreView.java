package calculator.core.view;

import camp.nextstep.edu.missionutils.Console;

import java.math.BigInteger;
import java.util.function.Function;

public class CalculatorCoreView {

    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT_MESSAGE = "결과 : %d";

    public void print(Function<String, BigInteger> function) {
        printInputMessage();
        printResult(function.apply(Console.readLine()));
    }

    private void printInputMessage() {
        printMessage(INPUT_MESSAGE);
    }

    private void printResult(BigInteger result) {
        printMessage(String.format(RESULT_MESSAGE, result));
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
