package calculator.model;

import calculator.model.separator.CustomSeparator;
import calculator.model.separator.DefaultSeparator;
import calculator.model.separator.Separator;

public class Calculator {
    private static final int MIN_NUMBER = 1;

    public int add(String input) {
        validateInput(input);

        Separator separator = new DefaultSeparator();
        int sum = 0;

        // 커스텀 구분자
        while (input.contains("//")) {
            separator = CustomSeparator.extractAndCombine(input, separator.getSeparator());
            sum += calculatePrefixSum(input, separator.getSeparator());
            input = updateInputString(input);
        }

        // 나머지 문자열에서 구분자 기준으로 숫자 분리 및 합산
        sum += sumNumbers(input.split(separator.getSeparator()));
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

    private static String updateInputString(String input) {
        int separatorIndex = input.indexOf("\\n");
        return input.substring(separatorIndex + 2);
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
