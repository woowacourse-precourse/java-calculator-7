package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String LINE_SEPARATOR = System.lineSeparator();

    public static final String ENTER_INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public String askInput() {
        System.out.print(ENTER_INPUT_MESSAGE);
        System.out.print(LINE_SEPARATOR);
        return Console.readLine();
    }
}
