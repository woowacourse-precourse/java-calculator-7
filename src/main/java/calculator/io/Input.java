package calculator.io;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String ZERO = "0";

    public static String inputMessage() {
        System.out.println(INPUT_MESSAGE);
        String input = Console.readLine();

        if (input.isBlank()) {
            return ZERO;
        }

        Console.close();
        return input;
    }

}
