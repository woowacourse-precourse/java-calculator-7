package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String ZERO = "0";

    public static String readInputString() {
        String userInput = Console.readLine();
        return validateEmpty(userInput);
    }

    private static String validateEmpty(String userInput) {
        if (userInput.isEmpty() | userInput.isBlank()) {
            return ZERO;
        }
        return userInput;
    }
}


