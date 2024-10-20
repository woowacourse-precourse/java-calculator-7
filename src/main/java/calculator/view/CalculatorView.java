package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {

    private static final String INPUT_GUIDE_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public String getUserInput() {
        System.out.println(INPUT_GUIDE_MESSAGE);
        return Console.readLine();
    }

    public void showResult(int result) {
        System.out.printf("결과 : %d%n", result);
        Console.close();
    }
}
