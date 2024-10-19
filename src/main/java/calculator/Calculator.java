package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String PREFIX_CUSTOM = "//";
    private static final String POSTFIX_CUSTOM = "\\n";
    private static final int CUSTOM_DELIMITER_LENGTH = 2;

    public static void run() {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();

        String[] numbers = splitString(input);
        System.out.println("분리된 숫자: ");
        for (String number : numbers) {
            System.out.println(number);
        }
    }

    public static String[] splitString(String input) {
        String delimiters = extractDelimiters(input);
        String numbersPart = extractNumbers(input);
        return numbersPart.split(delimiters);
    }

    private static String extractDelimiters(String input) {
        String delimiters = DEFAULT_DELIMITERS;
        if (hasCustomDelimiter(input)) {
            int customDelimiterEndIdx = input.indexOf(POSTFIX_CUSTOM);
            delimiters = input.substring(CUSTOM_DELIMITER_LENGTH, customDelimiterEndIdx);
        }
        return delimiters;
    }

    private static String extractNumbers(String input) {
        if (hasCustomDelimiter(input)) {
            int customDelimiterEndIdx = input.indexOf(POSTFIX_CUSTOM);
            return input.substring(customDelimiterEndIdx + 2);
        }
        return input;
    }

    private static boolean hasCustomDelimiter(String input) {
        return input.startsWith(PREFIX_CUSTOM) && input.contains(POSTFIX_CUSTOM);
    }
}
