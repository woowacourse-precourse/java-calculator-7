package calculator.util;

import java.util.ArrayList;
import java.util.List;

public class ValidationUtils {

    private ValidationUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static void validateNumbers(List<Integer> numbers) {
        validateNegativeNumbers(numbers);
        validateZero(numbers);
    }

    public static void validateCustomDelimiter(String delimiter) {
        validateNullOrEmpty(delimiter);
        validateSingleCharacter(delimiter);
        validateAllowedCharacters(delimiter);
    }

    public static void validateValidInteger(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력된 값이 유효한 정수가 아닙니다. 문제가 되는 입력값: [" + value + "]");
        }
    }

    private static void validateNegativeNumbers(List<Integer> numbers) {
        List<Integer> negativeNumbers = new ArrayList<>();

        for (int number : numbers) {
            if (number < 0) {
                negativeNumbers.add(number);
            }
        }

        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다. 문제가 되는 입력값: " + negativeNumbers);
        }
    }

    private static void validateZero(List<Integer> numbers) {
        if (numbers.contains(0)) {
            throw new IllegalArgumentException("0은 허용되지 않습니다. 문제가 되는 입력값: [0]");
        }
    }

    private static void validateNullOrEmpty(String delimiter) {
        if (delimiter == null || delimiter.trim().isEmpty()) {
            throw new IllegalArgumentException("유효하지 않은 커스텀 구분자입니다. 문제가 되는 입력값: [" + delimiter + "]");
        }
    }

    private static void validateSingleCharacter(String delimiter) {
        if (delimiter.length() != 1) {
            throw new IllegalArgumentException("유효하지 않은 커스텀 구분자입니다. 구분자는 단일 문자여야 합니다. 문제가 되는 입력값: [" + delimiter + "]");
        }
    }

    private static void validateAllowedCharacters(String delimiter) {
        List<String> disallowedCharacters = List.of("\n", "\t", "\r");

        if (disallowedCharacters.stream().anyMatch(delimiter::contains)) {
            throw new IllegalArgumentException("유효하지 않은 커스텀 구분자입니다. 허용되지 않는 문자가 포함되어 있습니다. 문제가 되는 입력값: [" + delimiter + "]");
        }
    }
}
