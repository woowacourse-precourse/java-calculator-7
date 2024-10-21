package calculator.output;

import calculator.constant.Constant;

public class OutputViewer {

    public static void printStartMessage() {
        System.out.println(Constant.CALCULATOR_START_MESSAGE);
    }

    public static void printResultMessage(int result) {
        System.out.println(Constant.RESULT_MESSAGE + result);
    }
}
