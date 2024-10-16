package calculator.util;

import calculator.exception.InvalidInputException;

public class NumberValidator {
    public static void isValidNumber(String numberString) {
        //TODO: 숫자 유효성 검증 유틸리티 메서드 구현
        try {
            int number = Integer.parseInt(numberString.trim());
            if (number < 0) {
                throw new InvalidInputException("음수는 허용되지 않습니다: " + number);
            }
        } catch (NumberFormatException e) {
            throw new InvalidInputException("유효하지 않은 숫자 형식입니다: " + numberString);
        }
    }
}
