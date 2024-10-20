package calculator.view;

import calculator.domain.Numbers;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {

    private static final String INPUT_REQUEST_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT_MESSAGE = "결과 : ";

    public static String getUserInput() {
        System.out.println(INPUT_REQUEST_MESSAGE);

        return Console.readLine();
    }

    public static void showResult(Numbers numbers) {
        System.out.println(RESULT_MESSAGE + numbers.getSummary());
    }
}