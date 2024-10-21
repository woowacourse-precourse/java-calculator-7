package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static final String INPUT_ADD_NUMBERS = "덧셈할 문자열을 입력해 주세요.";

    private Input() {
    }

    public static String start() {
        System.out.println(INPUT_ADD_NUMBERS);
        return Console.readLine();
    }
}
