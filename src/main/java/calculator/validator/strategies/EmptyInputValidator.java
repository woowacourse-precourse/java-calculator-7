package calculator.validator.strategies;

import calculator.view.ErrorMessage;

// 입력값이 비어 있거나 공백인지 검증하는 클래스
public class EmptyInputValidator implements ValidationStrategy {

    @Override
    public void validate(String input) {
        if (isNullOrEmpty(input)) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT_ERROR.getMessage());
        }
    }

    // 입력이 null이거나 빈 문자열인지 확인
    private boolean isNullOrEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

}