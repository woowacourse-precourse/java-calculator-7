package calculator.io;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public static String inputMessage() {
        System.out.println(INPUT_MESSAGE);
        String line = Console.readLine();

        if (line.isBlank()) {
            return "0";
        }

        Console.close();
        return line;
    }

    private static boolean isBlank(String line) {
        if (line.isBlank()) {
            return true;
        }
        return false;
    }

}
