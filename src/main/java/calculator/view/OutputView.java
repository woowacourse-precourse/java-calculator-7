package calculator.view;

import calculator.global.constants.MessageType;

public class OutputView {
    public static void printResult(int result) {
        System.out.print(MessageType.RESULT_MESSAGE.getMessage() + result);
    }

    public static void printMessage(MessageType messageType) {
        messageType.printMessage();
    }
}