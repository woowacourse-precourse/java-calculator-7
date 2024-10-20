package calculator.view;

import camp.nextstep.edu.missionutils.Console;
import calculator.global.constants.MessageType;
import static calculator.global.constants.MessageType.STRING_REQUEST_MESSAGE;


public final class View {
    public static String requestString() {
        printlnMessage(STRING_REQUEST_MESSAGE);
        return enterMessage();
    }

    /* Output View */
    private static void printlnMessage(MessageType messageType) {
        System.out.println(messageType.getMessage());
    }

    /* Input View */
    private static String enterMessage() {
        return Console.readLine();
    }
}