package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final String DEFAULT_SEPARATOR = ",|:";
    private static final String CUSTOM_SEPARATOR_PREFIX = "//";
    private static final String CUSTOM_SEPARATOR_SUFFIX = "\n";

    public static void main(String[] args) {
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine();
            int result = calculateNum(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static int calculateNum(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        String separator = DEFAULT_SEPARATOR;
        String numbersStr = input;

        if (hasCustomSeparator(input)) {
            separator = extractCustomSeparator(input);
            numbersStr = extractNumbersPart(input);
        }

        return calculateSum(numbersStr.split(separator));
    }

    private static boolean hasCustomSeparator(String input) {
        return input.startsWith(CUSTOM_SEPARATOR_PREFIX);
    }

    private static String extractCustomSeparator(String input) {
        return String.valueOf(input.charAt(2));
    }

    private static String extractNumbersPart(String input) {
        return input.substring(input.indexOf(CUSTOM_SEPARATOR_SUFFIX) + 1);
    }

    private static int calculateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += parseNumber(number.trim());
        }
        return sum;
    }

    private static int parseNumber(String number) {
        try {
            int result = Integer.parseInt(number);
            validatePositiveNumber(result);
            return result;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.");
        }
    }

    private static void validatePositiveNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }
}