package calculator.service.validation;

import static calculator.service.exception.SeparationExceptionType.NO_INPUT;

import calculator.service.exception.SeparationException;

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

}
