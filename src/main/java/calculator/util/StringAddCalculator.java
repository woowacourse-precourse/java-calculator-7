package calculator.util;

import calculator.model.primitive.PositiveNumber;

public class StringAddCalculator {

    private static final long ZERO_VALUE = 0L;
    private static final String BLANK = " ";
    private static final String CONTAIN_BLANK_EXCEPTION_MESSAGE = "공백을 포함할 수 없습니다.";
    private static final String INVALID_DELIMITER_EXCEPTION_MESSAGE =
            "구분자가 잘못 되었습니다. 커스텀 구분자, 기본 구분자를 확인 후, "
                    + "다시 입력하세요";

    public static long splitAndSum(String input) {
        if (validateNullOrEmpty(input)) {
            return ZERO_VALUE;
        }
        validateContainBlank(input);

        return calculateSum(splitByInput(input));
    }

    private static boolean validateNullOrEmpty(String input) {
        return isNull(input) || isEmpty(input);
    }

    private static boolean isNull(String input) {
        return input == null;
    }

    private static boolean isEmpty(String input) {
        return input.isEmpty();
    }

    private static void validateContainBlank(String input) {
        if (isContainBlank(input)) {
            throw new IllegalArgumentException(CONTAIN_BLANK_EXCEPTION_MESSAGE);
        }
    }

    private static boolean isContainBlank(String input) {
        return input.contains(BLANK);
    }

    private static String[] splitByInput(String input) {
        return Separator.splitByDelimiter(input);
    }

    private static long calculateSum(String[] splitInput) {
        long sum = ZERO_VALUE;
        for (String splitNumber : splitInput) {
            PositiveNumber positiveNumber = PositiveNumber.of(toLong(splitNumber));
            sum = positiveNumber.addNumber(sum);
        }
        return sum;
    }

    private static long toLong(String splitNumber) {
        return parseNumber(splitNumber);
    }

    private static long parseNumber(String splitNumber) {
        try {
            return Long.parseLong(splitNumber);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(INVALID_DELIMITER_EXCEPTION_MESSAGE);
        }
    }
}
