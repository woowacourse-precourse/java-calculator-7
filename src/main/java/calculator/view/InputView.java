package calculator.view;

import calculator.global.constants.MessageType;
import camp.nextstep.edu.missionutils.Console;
import calculator.global.validator.Validator;

public class InputView {
    public static String requestString() {
        printlnMessage(MessageType.STRING_REQUEST_MESSAGE);
        return enterMessage();
    }

    private static void printlnMessage(MessageType messageType) {
        System.out.println(messageType.getMessage());
    }

    private static String enterMessage() {
        String message = Console.readLine();
        Validator.validateNotEmpty(message);
        return message;
    }
}
