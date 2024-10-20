package calculator.handler;

import static calculator.constant.Message.*;

public class OutputHandler {
    public static void printResult(int result) {
        System.out.println(CALCULATOR_RESULT_PREFIX+ result);
    }

    public static void printError(String errorMessage) {
        System.out.println(CALCULATOR_ERROR_PREFIX+ errorMessage);
    }
}
