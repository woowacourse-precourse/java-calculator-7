package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class CalculateView {
    private static final String INPUT_GUIDE = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT_MESSAGE = "결과 : ";

    public String getUserInput() {
        System.out.println(INPUT_GUIDE);
        return Console.readLine();
    }

    public void displayResult(int cnt) {
        System.out.println(RESULT_MESSAGE + cnt);
    }
}
