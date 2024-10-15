package calculator.View;

import calculator.Constants.InputMessages;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    InputView() {
    }

    public static void printInsertMessage() {
        System.out.println(InputMessages.INSERT_STRING);
    }

    public static String getUserInput() {
        String userInput = Console.readLine();

        return userInput;
    }

}
