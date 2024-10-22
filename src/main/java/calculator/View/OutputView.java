package calculator.View;

import calculator.Message.ViewMessage;

public class OutputView {
    public static void printResult(int result) {
        System.out.println(ViewMessage.PRINT_RESULT_MESSAGE + result);
    }
}
