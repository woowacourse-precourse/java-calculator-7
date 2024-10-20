package calculator.view;


import calculator.global.constants.MessageType;
import static calculator.global.constants.MessageType.STRING_REQUEST_MESSAGE;


public final class View {
    public static String requestString() {
        printlnMessage(STRING_REQUEST_MESSAGE);
    }

    /* Output View */
    private static void printlnMessage(MessageType messageType) {
        System.out.println(messageType.getMessage());
    }
}