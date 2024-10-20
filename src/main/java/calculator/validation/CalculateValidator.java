package calculator.validation;

import calculator.error.CustomException;
import calculator.message.ErrorMessage;

import java.util.Optional;

public class CalculateValidator {
    private CalculateValidator() {
    }

    // 문자열 정수로 변환하고, 양수인지 검증
    public int parseToInt(String number) {
        return Optional.of(number)
                .map(String::trim)
                .map(this::validateAndParse)
                .filter(this::isPositive)
                .orElseThrow(() -> CustomException.from(ErrorMessage.NOT_ALLOWED_NEGATIVE_NUMBER)); // 0 이하일 경우 예외 발생
    }

    // 숫자 형식인지 검증하고 정수로 변환
    private int validateAndParse(String s) {
        return Optional.of(s)
                .filter(str -> ValidationPattern.INTEGER_PATTERN.getPattern().matcher(str).matches()) // 정규식을 사용하여 숫자 형식 검증
                .map(Integer::parseInt)
                .orElseThrow(() -> CustomException.from(ErrorMessage.INVALID_NUMBER_FORMAT)); // 변환 실패 시 예외 발생
    }

    // 양수인지 검증
    private boolean isPositive(int num) {
        return num > 0;
    }
}

