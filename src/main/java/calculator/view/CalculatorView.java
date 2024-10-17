package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {

    private static final String INPUT_REQUEST_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public static String getUserInput() {
        System.out.println(INPUT_REQUEST_MESSAGE);

        return Console.readLine();
    }
}