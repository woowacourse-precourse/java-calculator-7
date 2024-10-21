package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_ADD_DATA_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public String inputStrings() {
        System.out.println(INPUT_ADD_DATA_MESSAGE);
        return Console.readLine();
    }
}



