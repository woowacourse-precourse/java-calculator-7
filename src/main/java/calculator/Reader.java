package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Reader {
    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해주세요.";

    public static String getInput() {
        printInputMessage();
        return Console.readLine();
    }

    public static void close() {
        Console.close();
    }

    private static void printInputMessage() {
        System.out.println(INPUT_MESSAGE);
    }
}
