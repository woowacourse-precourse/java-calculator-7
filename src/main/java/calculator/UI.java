package calculator;

import camp.nextstep.edu.missionutils.Console;

public class UI {
    private static final String READ_INPUT_STATEMENT = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT_STATEMENT = "결과 : ";

    public String getInput() {
        System.out.println(READ_INPUT_STATEMENT);
        return Console.readLine();
    }

    public void printOutput(int output) {
        System.out.println(RESULT_STATEMENT + output);
    }
}
