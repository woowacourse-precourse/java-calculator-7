package calculator.view;

import calculator.global.constants.MessageType;

public class OutputView {
    public static void printResult(int result) {
        System.out.println("결과 : " + result);
    }

    public static void printlnMessage(MessageType messageType) {
        System.out.println(messageType.getMessage());
    }
}
