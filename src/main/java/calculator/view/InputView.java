package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String CALCULATOR_START_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public String getInputString() {
        System.out.println(CALCULATOR_START_MESSAGE);
        
        return Console.readLine();
    }
}
