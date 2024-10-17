package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputOutputManager {
    private static final String GUIDE_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT_MESSAGE = "결과 : ";

    public static String inputMessage() {
        System.out.println(GUIDE_MESSAGE);
        return Console.readLine();
    }

    public static void outputMessage(String message) {
        System.out.print(RESULT_MESSAGE);
        System.out.println(message);

    }
}