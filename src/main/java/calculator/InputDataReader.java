package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputDataReader {

    private static String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public static String getInputData() {
        printInputMessage();
        return Console.readLine();
    }

    private static void printInputMessage() {
        System.out.println(INPUT_MESSAGE);
    }

}
