package calculator.view;

import static calculator.global.Message.RESULT_MESSAGE;

public class OutputView {

    public static void printSumResult(double num) {

        if (num == Math.floor(num)) {
            System.out.println(RESULT_MESSAGE.getMessage() + (int) num);
        } else {
            System.out.println(RESULT_MESSAGE.getMessage() + num);
        }
    }
}
