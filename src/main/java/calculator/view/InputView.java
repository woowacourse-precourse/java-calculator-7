package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String READ_STRING_TO_ADD_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public String readStringToAdd() {
        return readLineWithPrompt(READ_STRING_TO_ADD_MESSAGE);
    }

    private String readLineWithPrompt(String prompt) {
        System.out.println(prompt);
        return Console.readLine().strip();
    }
}