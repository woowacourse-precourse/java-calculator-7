package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String inputString() {
        return Console.readLine();
    }

    public static void printMessage(PrintMessage message) {
        System.out.println(message.getMessage());
    }

    public static void printInputMessage() {
        printMessage(PrintMessage.USER_INPUT_MESSAGE);
    }
}
