package calculator.domain.machine;

import camp.nextstep.edu.missionutils.Console;

public class View {

    private static final String INPUT_REQUEST_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT_MESSAGE = "결과 : ";

    public void printInputRequestMsg() {
        System.out.println(INPUT_REQUEST_MESSAGE);
    }

    public String readInputMsg() {
        String readLine = Console.readLine();
        Console.close();

        return readLine;
    }

    public void printResult(Long value) {
        System.out.println(RESULT_MESSAGE + value);
    }
}
