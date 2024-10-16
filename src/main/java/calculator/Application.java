package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public static void main(String[] args) {
        String inputData = getInputData();
    }

    private static String getInputData() {
        System.out.println(INPUT_MESSAGE);
        return Console.readLine();
    }
}
