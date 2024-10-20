package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_STRING_MSG = "덧셈할 문자열을 입력해 주세요.";

    public String inputString() {
        System.out.println(INPUT_STRING_MSG);
        return Console.readLine();
    }

}
