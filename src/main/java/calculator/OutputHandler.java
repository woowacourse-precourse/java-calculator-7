package calculator;

import camp.nextstep.edu.missionutils.Console;

public class OutputHandler {
    private static final String RESULT_MESSAGE = "결과: %d";

    public static void printResult(int result) {
        System.out.printf(RESULT_MESSAGE, result);
        Console.close();
    }
}
