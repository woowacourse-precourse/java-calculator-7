package calculator;

import camp.nextstep.edu.missionutils.Console;

public class CaculatorView {
    private static final String READ_NUMBER_MESSAGE = "숫자를 입력하세요";
    private static final String RESULT_MESSAGE = "실행 결과";

    public static String readNumbers() {
        System.out.println(READ_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public static void printResult(int result) {
        System.out.println(RESULT_MESSAGE + result);
    }
}
