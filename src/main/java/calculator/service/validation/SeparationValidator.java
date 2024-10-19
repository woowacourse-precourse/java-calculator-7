package calculator.service.validation;

import static calculator.service.exception.SeparationExceptionType.ENDS_WITH_SEPARATOR;
import static calculator.service.exception.SeparationExceptionType.INVALID_SEPARATOR;
import static calculator.service.exception.SeparationExceptionType.NO_INPUT;
import static calculator.service.exception.SeparationExceptionType.STARTS_WITH_SEPARATOR;

import calculator.service.exception.SeparationException;
import java.util.Arrays;

public class SeparationValidator {

    public static void validate(String input, String... separators) {
        validateExistInput(input);
        validateStartsWithSeparator(input, separators);
        validateEndWithSeparator(input, separators);
        validateIsDigit(input, separators);
    }

    // 입력값이 존재하는지 검증합니다.
    private static void validateExistInput(String input) {
        if (input.isBlank()) {
            throw new SeparationException(NO_INPUT);
        }
    }

    // 입력값이 구분자로 시작하는지 검증합니다.
    private static void validateStartsWithSeparator(String input, String... separators) {
        if (Arrays.stream(separators).anyMatch(input::startsWith)) {
            throw new SeparationException(STARTS_WITH_SEPARATOR);
        }
    }

    // 입력값이 구분자로 끝나는지 검증합니다.
    private static void validateEndWithSeparator(String input, String... separators) {
        if (Arrays.stream(separators).anyMatch(input::endsWith)) {
            throw new SeparationException(ENDS_WITH_SEPARATOR);
        }
    }

    // 구분자로 나뉘어진 모든 요소가 숫자인지 검증합니다.
    private static void validateIsDigit(String input, String... separators) {
        String regex = String.join("|", separators);
        if (!Arrays.stream(input.split(regex)).allMatch(str -> isDigit(str))) {
            throw new SeparationException(INVALID_SEPARATOR);
        }
    }

    private static boolean isDigit(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
