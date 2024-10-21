package calculator.view;

import camp.nextstep.edu.missionutils.Console;
import calculator.global.constants.MessageType;
import static calculator.global.constants.MessageType.STRING_REQUEST_MESSAGE;
import calculator.global.validator.Validator;

public final class View {
    public static String requestString() {
        printlnMessage(STRING_REQUEST_MESSAGE);
        return enterMessage();
    }

    /* Output View */
    private static void printlnMessage(MessageType messageType) {
        System.out.println(messageType.getMessage());
    }

    public static void printResult(int result) {
        System.out.println("결과 : " + result);
    }

    /* Input View */
    private static String enterMessage() {
        String message = Console.readLine();
        Validator.validateNotEmpty(message);
        return message;
    }
}