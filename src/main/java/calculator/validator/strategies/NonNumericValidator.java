package calculator.validator.strategies;

import calculator.util.DelimiterUtils;
import calculator.view.ErrorMessage;

// 숫자가 아닌 입력값을 검증하는 클래스
public class NonNumericValidator implements ValidationStrategy {

    @Override
    public void validate(String input) {
        // 입력 문자열이 숫자와 구분자로만 이루어져 있는지 확인
        if (!containsOnlyValidCharacters(input)) {
            throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC_INPUT_ERROR.getMessage());
        }
    }

    // 입력이 숫자와 구분자로만 이루어져 있는지 확인
    private boolean containsOnlyValidCharacters(String input) {
        String[] numbers = DelimiterUtils.splitInput(input);

        // 숫자 배열을 확인하여 유효한지 판단
        for (String number : numbers) {
            if (!isValidNumber(number)) {
                return false;
            }
        }
        return true; // 모든 숫자가 유효할 경우
    }

    // 숫자가 유효한지 확인하는 헬퍼 메서드
    private boolean isValidNumber(String number) {
        // 빈 문자열일 경우도 유효한 것으로 간주
        if (number.isEmpty()) {
            return true;
        }
        return number.matches("[0-9]+"); // 숫자만 포함된 문자열인지 확인
    }

}