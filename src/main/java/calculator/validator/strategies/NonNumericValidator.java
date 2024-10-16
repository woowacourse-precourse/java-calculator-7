package calculator.validator.strategies;

import calculator.view.ErrorMessage;

// 입력값에 숫자 외의 문자가 포함되어 있는지 확인하는 클래스
public class NonNumericValidator implements ValidationStrategy {

    private static final String VALID_INPUT_PATTERN = "[0-9,;:]*";

    @Override
    public void validate(String input) {
        if (isNotNumeric(input)) {
            throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC_INPUT_ERROR.getMessage());
        }
    }

    // 입력이 숫자와 허용된 구분자로만 이루어져 있는지 확인
    private boolean isNotNumeric(String input) {
        return !input.matches(VALID_INPUT_PATTERN);
    }

}