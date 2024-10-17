package calculator.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final String INPUT_MESSAGE= "덧셈할 문자열을 입력해 주세요.";

    public InputView() {
    }

    public String input() {
        System.out.println(INPUT_MESSAGE);
        return Console.readLine();
    }
}
