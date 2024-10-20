package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String delimiters = ":,";

        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();

        if (isCustomDelimiterDefined(input)) {
            delimiters = getCustomDelimiter(input);
        }
    }

    private static boolean isCustomDelimiterDefined(String input) {
        return input.startsWith("//") && (input.indexOf("\n") == input.indexOf("//") + 3);
    }

    private static String getCustomDelimiter(String input) {

        int startIndex = input.indexOf("//") + 2;
        int endIndex = input.indexOf("\n");

        String customDelimiter = input.substring(startIndex, endIndex);

        return customDelimiter;
    }
}
