package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    private static final String REQUEST_STRING_NUMBERS = "덧셈할 문자열을 입력해 주세요.";

    public String readStringNumbers() {
        System.out.println(REQUEST_STRING_NUMBERS);
        return readLineWithoutBlank();
    }

    public void closeConsole() {
        Console.close();
    }

    private String readLineWithoutBlank() {
        return Console.readLine().trim();
    }
}