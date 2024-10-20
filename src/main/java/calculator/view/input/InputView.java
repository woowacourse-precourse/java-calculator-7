package calculator.view.input;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    private InputView() {
    }

    public static String readCalcString() {
        System.out.println(INPUT_MESSAGE);
        return Console.readLine();
    }
}
