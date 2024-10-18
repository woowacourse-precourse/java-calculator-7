package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleView {

    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String OUTPUT_MESSAGE = "결과 : %s\n";

    public String requestInput() {
        System.out.println(INPUT_MESSAGE);
        return Console.readLine();
    }

    public void printResult(Number result) {
        System.out.printf(OUTPUT_MESSAGE, result);
    }
}
