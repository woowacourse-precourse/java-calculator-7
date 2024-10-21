package calculator.view;


import static calculator.enumStatus.ExceptionMessage.INVALID_INPUT_ZERO;
import static calculator.enumStatus.UserMessage.START_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class StartView {
    public static void printStartView() {
        System.out.println(START_MESSAGE);
    }

    public static String getInputView() {
        String input = Console.readLine();
        validateInputZero(input);
        return input;
    }

    private static void validateInputZero(String input) {
        if (input.contains("0")) {
            throw new IllegalArgumentException(INVALID_INPUT_ZERO.toString());
        }
    }
}
