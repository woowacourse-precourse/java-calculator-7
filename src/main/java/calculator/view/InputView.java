package calculator.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String NUMBERS_INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public String numbersInputView() {
        System.out.println(NUMBERS_INPUT_MESSAGE);
        return readLine();
    }
}
