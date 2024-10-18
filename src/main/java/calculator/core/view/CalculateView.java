package calculator.core.view;

import camp.nextstep.edu.missionutils.Console;

import java.math.BigInteger;
import java.util.function.Function;

import static calculator.constant.CalculateMessage.INPUT;
import static calculator.constant.CalculateMessage.RESULT_FORMAT;

public class CalculateView {

    public void print(Function<String, BigInteger> function) {
        printInputMessage();
        printResultMessage(function.apply(Console.readLine()));
    }

    private void printInputMessage() {
        printMessage(INPUT.getMessage());
    }

    private void printResultMessage(BigInteger result) {
        printMessage(RESULT_FORMAT.getFormatMessage(result));
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
