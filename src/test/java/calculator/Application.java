package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final String DEFAULT_SEPARATOR = ",|:";
    private static final String CUSTOM_SEPARATOR_PREFIX = "//";
    private static final String CUSTOM_SEPARATOR_SUFFIX = "\n";

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        System.out.println("결과 : " + calculateNum(input));
    }

    private static int calculateNum(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        String separator = DEFAULT_SEPARATOR;
        String numbersStr = input;

        if (hasCustomSeparator(input)) {
            separator = extractCustomSeparator(input);
            numbersStr = extractNumbers(input);
        }

        return calculateSum(numbersStr.split(separator));
    }

    private static boolean hasCustomSeparator(String input) {
        return input.startsWith(CUSTOM_SEPARATOR_PREFIX);
    }

    private static String extractCustomSeparator(String input) {
        char separator = input.charAt(2);
        if (separator == '\\') {
            return "\\" + input.charAt(3);
        }
        return String.valueOf(separator);
    }

    private static String extractNumbers(String input) {
        int suffixIndex = input.indexOf(CUSTOM_SEPARATOR_SUFFIX);
        if (suffixIndex == -1) {
            throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
        }
        return input.substring(suffixIndex + 1);
    }

    private static int calculateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            if (!number.trim().isEmpty()) {
                sum += parseNumber(number.trim());
            }
        }
        return sum;
    }

    private static int parseNumber(String number) {
        try {
            int result = Integer.parseInt(number);
            if (result < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
            return result;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.");
        }
    }
}