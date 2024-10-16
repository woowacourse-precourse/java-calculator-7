package calculator.validator.strategies;

import calculator.view.ErrorMessage;

// 입력값에 음수가 포함되어 있는지 확인하는 클래스
public class NegativeNumberValidator implements ValidationStrategy {

    private static final String DELIMITER_REGEX = "[,;:]";

    @Override
    public void validate(String input) {
        String[] numbers = splitInput(input);
        if (containsNegativeNumber(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER_ERROR.getMessage());
        }
    }

    // 입력 문자열을 구분자로 나누어 숫자 배열을 반환
    private String[] splitInput(String input) {
        return input.split(DELIMITER_REGEX);
    }

    // 숫자 배열에 음수가 있는지 확인
    private boolean containsNegativeNumber(String[] numbers) {
        for (String number : numbers) {
            if (isNegative(number)) {
                return true;
            }
        }
        return false;
    }

    // 음수인지 확인
    private boolean isNegative(String number) {
        try {
            return Integer.parseInt(number) < 0;
        } catch (NumberFormatException e) {
            return false;  // 숫자가 아닌 경우 음수로 처리되지 않음
        }
    }

}