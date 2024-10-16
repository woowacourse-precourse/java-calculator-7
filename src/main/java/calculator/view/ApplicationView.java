package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class ApplicationView {
    private static final String INPUT_PROMPT = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT_TEXT = "결과 : ";

    public static String getInput() {
        System.out.println(INPUT_PROMPT);
        return Console.readLine();
    }

    public static void printOutput(int sum) {
        System.out.print(RESULT_TEXT + sum);
    }
}
