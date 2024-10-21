package calculator.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private static final String startMessage = "덧셈할 문자열을 입력해 주세요.";

    public static void printStartMessage() {
        System.out.println(startMessage);
    }

    public static String readInputString() {
        String input = readLine();
        validateContainSpace(input);
        return input;
    }

    public static void validateContainSpace(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("[ERROR] 문자열에 빈칸이 포함되어 있습니다.");
        }
    }
}
