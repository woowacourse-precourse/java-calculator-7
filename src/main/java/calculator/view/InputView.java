package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public String input() {
        // 입력 메시지 출력
        System.out.println(MESSAGE);

        return Console.readLine();
    }
}
