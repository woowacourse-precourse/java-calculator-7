package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_PROMPT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    /**
     * 사용자 입력을 처리하는 메서드.
     *
     * @return 사용자 입력 문자열
     */
    public String input() {
        System.out.println(INPUT_PROMPT_MESSAGE);
        return Console.readLine();
    }
}
