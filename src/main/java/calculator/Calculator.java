package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {
    private static final String ENTER_MESSAGE = "덧셈할 문자열을 입력해주세요.";
    private static final String COLON_SEPARATOR = ":";
    private static final String COMMA_SEPARATOR = ",";
    private static final String SLASH_SEPARATOR = "//";
    private static final String LINE_BREAKING_SEPARATOR = "\n";

    public static void start() {
        System.out.println(ENTER_MESSAGE);
        String userInput = Console.readLine();
    }

}
