package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class StringReader {

    private final String MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public String read() {
        System.out.println(MESSAGE);
        return Console.readLine();
    }
}
