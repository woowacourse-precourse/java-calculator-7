package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String readInputString() {
        String userInput = Console.readLine();
        return validateEmpty(userInput);
    }

    private static String validateEmpty(String userInput) {
        if (userInput.isEmpty()) {
            return "0";
        }
        return userInput;
    }
}


