package calculator.util;

import static calculator.constant.OutputMessage.ADDITION_RESULT;
import static calculator.constant.OutputMessage.INPUT_ADDITION;

public class MessageUtil {
    public void printStringForSum() {
        System.out.println(INPUT_ADDITION.getMessage());
    }

    public void printResult(Integer result) {
        System.out.printf(ADDITION_RESULT.getMessage(), result);
    }
}
