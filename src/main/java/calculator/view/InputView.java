package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해주세요.";

    public String inputMessage() {
        System.out.println(INPUT_MESSAGE);
        return Console.readLine();
    }

}
