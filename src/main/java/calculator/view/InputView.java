package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private String inputString;
    private static final String OUTPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public String getUserInput() {
        System.out.println(OUTPUT_MESSAGE);
        inputString = Console.readLine();
        return inputString;
    }
}
