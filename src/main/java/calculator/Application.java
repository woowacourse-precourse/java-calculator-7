package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String delimiters = ":,";

        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();
        boolean isCustomDelimiter = false;

        if (isCustomDelimiterDefined(input)) {
            delimiters = getCustomDelimiter(input);
            isCustomDelimiter = true;
        }

        if (!isValidInput(input, delimiters, isCustomDelimiter)) {
            throw new IllegalArgumentException("입력값이 유효하지 않습니다.");
        }
    }

    private static boolean isValidInput(String input, String delimiters, boolean isCustomDelimiter) {
        if (input.isBlank()) {
            return true;
        }

        String validTarget = input;

        if (isCustomDelimiter) {
            validTarget = input.substring(input.indexOf("\n") + 1);
        }

        String regex = "^\\d+(" + "[" + delimiters + "]" + "\\d+)*$";

        return validTarget.matches(regex);
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
