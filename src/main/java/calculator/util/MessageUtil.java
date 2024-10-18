package calculator.util;

import static calculator.constant.MessageConstant.ADDITION_RESULT;
import static calculator.constant.MessageConstant.INPUT_ADDITION;

public class MessageUtil {
    public void printStringForSum() {
        System.out.println(INPUT_ADDITION.getMessage());
    }

    public void printResult(Integer result) {
        System.out.printf(ADDITION_RESULT.getMessage(), result);
    }
}
