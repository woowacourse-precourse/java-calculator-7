package calculator.service.validation;

import static calculator.service.exception.SeparationExceptionType.NO_INPUT;
import static calculator.service.exception.SeparationExceptionType.STARTS_WITH_SEPARATOR;

import calculator.service.exception.SeparationException;
import java.util.Arrays;

public class SeparationValidator {

    public static void validate(String input, String... separators) {
        validateExistInput(input);
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
}
