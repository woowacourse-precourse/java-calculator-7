package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputNumber {
    private static final String GUIDE_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public String inputMessage() {
        System.out.println(GUIDE_MESSAGE);
        return Console.readLine();
    }
}