package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static final String ASK_INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public static void main(String[] args) {
        final String input;

        System.out.println(ASK_INPUT_MESSAGE);
        input = Console.readLine();
    }
}
