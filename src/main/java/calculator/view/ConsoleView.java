package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleView {

    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public String requestInput() {
        System.out.println(INPUT_MESSAGE);
        return Console.readLine();
    }

    public void printResult(double result) {
        Number number = checkNumber(result);
        System.out.println("결과 : " + number);
    }

    private Number checkNumber(double result) {
        if (result % 1 == 0) {
            return (int) result;
        }
        return result;
    }
}
