package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputOutputService {
    private final String inputComment = "덧셈할 문자열을 입력해 주세요.";

    public String fetchUserInput() {
        System.out.println(inputComment);

        return Console.readLine();
    }
}
