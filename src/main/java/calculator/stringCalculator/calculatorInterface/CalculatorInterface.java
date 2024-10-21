package calculator.stringCalculator.calculatorInterface;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorInterface {

    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT_MESSAGE = "결과 : ";

    public void printResult(long result) {
        System.out.println(RESULT_MESSAGE + result);
    }

    public String getUserInput() {
        printInputMessage();
        return Console.readLine();
    }

    private void printInputMessage() {
        System.out.println(INPUT_MESSAGE);
    }
}
