package calculator;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorController {
    private final static String START_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public void run() {
        String value = getInput();

    }

    private String getInput() {
        System.out.println(START_MESSAGE);
        return Console.readLine();
    }
}
