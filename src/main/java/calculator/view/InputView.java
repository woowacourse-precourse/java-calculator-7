package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_VALUE_START_MSG ="덧셈할 문자열을 입력해 주세요.";

    public String inputValue() {
        System.out.println(INPUT_VALUE_START_MSG);
        return Console.readLine();
    }
}
