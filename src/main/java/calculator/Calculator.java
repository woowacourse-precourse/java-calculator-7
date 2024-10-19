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

        try {
            int result = add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] numbers = splitString(input);
        return sumString(numbers);
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

    private static int sumString(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            if (!number.trim().isEmpty()) {
                int num = parseNumber(number.trim());
                validateNumber(num);
                sum += num;
            }
        }
        return sum;
    }

    private static int parseNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자가 포함되어 있습니다: " + number);
        }
    }

    private static void validateNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + number);
        }
    }
}
