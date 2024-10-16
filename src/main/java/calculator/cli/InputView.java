package calculator.cli;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public InputView() {
    }

    //초기 메세지를 출력하고, 사용자로부터 값을 입력받음.
    public String inputMessage() {
        System.out.println(INPUT_MESSAGE);

        return Console.readLine();
    }
}
