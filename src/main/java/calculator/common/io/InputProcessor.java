package calculator.common.io;

import camp.nextstep.edu.missionutils.Console;

public class InputProcessor {

    private static final String MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public String getUserInput() {
        System.out.println(MESSAGE);
        String userInput = Console.readLine();
        if (userInput == null || userInput.isBlank()) {
            return "";
        }
        return userInput;
    }
}
