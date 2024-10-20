package calculator.validation;

import calculator.error.CustomException;
import calculator.message.ErrorMessage;

import java.util.Optional;
import java.util.regex.Matcher;

public class InputValidator {

    // 입력 문자열이 null이거나 비어 있는지 확인
    public static void checkForEmptyInput(String input) {
        Optional.ofNullable(input)
                .filter(s -> !s.isBlank())
                .orElseThrow(() -> CustomException.from(ErrorMessage.INVALID_WHITESPACE));
    }

    // 사용자 정의 구분자가 포함된 입력을 검증
    public static Matcher validateCustomDelimiter(String input) {
        return Optional.of(input)
                .map(InputPattern.CUSTOM_DELIMITER_PATTERN.getPattern()::matcher)
                .filter(Matcher::find)
                .orElseThrow(() -> CustomException.from(ErrorMessage.MISSING_CUSTOM_DELIMITER_END));
    }

    // 구분자에 숫자가 포함된 경우 유효성 검증
    public static void validateDelimiter(String customDelimiter) {
        Optional.of(customDelimiter)
                .filter(delimiter -> InputPattern.INTEGER_PATTERN.getPattern().matcher(delimiter).find())
                .ifPresent(delimiter -> {
                    throw CustomException.from(ErrorMessage.MISSING_CUSTOM_DELIMITER_END);
                });
    }
}
