package calculator.validator.strategies;

import calculator.util.DelimiterUtils;
import calculator.view.ErrorMessage;
import java.util.Arrays;

// 숫자가 존재하지 않을 경우 검증
public class EmptyNumberValidator implements ValidationStrategy {

    @Override
    public void validate(String input) {
        if (isBlank(input)) {
            return;  // 빈 입력일 경우 검증 통과 (예외 던지지 않음)
        }

        String[] numbers = DelimiterUtils.splitByDelimiter(input);
        if (numbers.length == 0 || allNumbersAreEmpty(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_NUMBER_ERROR.getMessage());
        }
    }

    private boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }

    private boolean allNumbersAreEmpty(String[] numbers) {
        return Arrays.stream(numbers)
                .allMatch(String::isEmpty);  // 모든 요소가 빈 문자열인지 검사
    }

}