package calculator.service;

import calculator.exception.CustomException;
import calculator.exception.ErrorCode;

public class Validator {
    public void validateLetterContain(String[] expression) {
        for (String e : expression) {
            if (Character.isLetter(e.charAt(0))) {
                throw new CustomException(ErrorCode.INVALID_INPUT, "문자는 입력할 수 없습니다.");
            }
        }
    }
}
