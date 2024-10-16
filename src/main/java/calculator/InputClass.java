package calculator;

import java.util.Scanner;

public class InputClass {

    private final String LEFT_CUSTOM_SEPARATOR = "//";
    private final String RIGHT_CUSTOM_SEPARATOR = "\\n";
    private static final String INPUT_SENTENCE = "덧셈할 문자열을 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    public static String input() {
        System.out.println(INPUT_SENTENCE);
        String inputText = scanner.nextLine();
        return inputText;
    }

    public Boolean existCustomSeparator(String inputText) {
        if ((inputText.contains(LEFT_CUSTOM_SEPARATOR)) && (inputText.contains(RIGHT_CUSTOM_SEPARATOR))) {
            return true;
        }
        return false;
    }
}
