package calculator.model;

import java.util.regex.Pattern;

public class Calculator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_CUSTOM_SEPARATOR_LENGTH = 1;

    public static int add(String input) {
        validateInput(input);

        String separator = "[,:]"; // 기본 구분자: 쉼표와 콜론
        int sum = 0;

        // 커스텀 구분자
        while (input.contains("//")) {
            // 커스텀 구분자 앞부분의 숫자 부분을 먼저 계산
            sum += calculatePrefixSum(input, separator);
            separator = addCustomSeparator(input, separator);
            input = updateInputString(input);
        }

        // 나머지 문자열에서 구분자 기준으로 숫자 분리 및 합산
        sum += sumNumbers(input.split(separator));
        return sum;
    }

    private static void validateInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력 값이 비어있습니다.");
        }
    }

    private static int calculatePrefixSum(String input, String separator) {
        String prefix = input.substring(0, input.indexOf("//")).trim();
        if (!prefix.isEmpty()) {
            return sumNumbers(prefix.split(separator));
        }
        return 0;
    }

    private static String addCustomSeparator(String input, String separator) {
        int separatorIndex = input.indexOf("\\n");
        if (separatorIndex == -1) {
            throw new IllegalArgumentException("커스텀 구분자 형식이 잘못되었습니다.");
        }

        String customSeparator = input.substring(input.indexOf("//") + 2, separatorIndex);
        validateCustomSeparator(customSeparator);

        return separator + "|" + Pattern.quote(customSeparator);
    }

    private static String updateInputString(String input) {
        int separatorIndex = input.indexOf("\\n");
        return input.substring(separatorIndex + 2);
    }

    private static void validateCustomSeparator(String customSeparator) {
        if (customSeparator.length() > MAX_CUSTOM_SEPARATOR_LENGTH) {
            throw new IllegalArgumentException("커스텀 구분자는 한 글자만 가능합니다.");
        }
        if (Pattern.matches("\\d", customSeparator)) {
            throw new IllegalArgumentException("커스텀 구분자는 숫자가 될 수 없습니다.");
        }
        if (customSeparator.isEmpty() || customSeparator.trim().isEmpty()) {
            throw new IllegalArgumentException("커스텀 구분자는 공백이 될 수 없습니다.");
        }
    }

    // 숫자 배열의 합을 계산하는 메서드
    private static int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            if (!number.trim().isEmpty()) {
                try {
                    int num = Integer.parseInt(number.trim());
                    if (num < MIN_NUMBER) {
                        throw new IllegalArgumentException("숫자는 1 이상의 양수여야 합니다.");
                    }
                    sum += num;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("문자열은 숫자와 구분자로만 이루어져야 합니다.");
                }
            }
        }
        return sum;
    }
}
