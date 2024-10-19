package calculator.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 문자열을 입력 받기 위한 InputView
 */
public class InputView {
    private static final String INPUT_STRING_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    /**
     * 사용자 입력을 받기 위한 메소드
     * @return Console을 통해 사용자로부터 입력 받은 문자열
     */
    public String enterInputString() {
        System.out.println(INPUT_STRING_MESSAGE);
        return Console.readLine();
    }
}
