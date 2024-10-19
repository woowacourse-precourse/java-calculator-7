package calculator.validator.strategies;

import calculator.util.DelimiterUtils;
import calculator.view.ErrorMessage;
import java.util.Arrays;

// 숫자가 아닌 입력값을 검증하는 클래스
public class NumericValidator implements ValidationStrategy {

    @Override
    public void validate(String input) {
        // 입력 문자열이 숫자와 구분자로만 이루어져 있는지 확인
        if (!containsOnlyValidCharacters(input)) {
            throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC_INPUT_ERROR.getMessage());
        }
    }

    // 입력이 숫자와 구분자로만 이루어져 있는지 확인
    private boolean containsOnlyValidCharacters(String input) {
        return Arrays.stream(DelimiterUtils.splitByDelimiter(input))  // 문자열 배열을 스트림으로 변환
                .allMatch(this::isValidNumber);  // 모든 요소가 유효한지 검사
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