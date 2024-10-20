package calculator;

import java.util.List;

public class Validator {

    public void validate(String userInput, List<String> numbers, String delimiter) {
        checkContainsNegative(userInput, delimiter);
        checkContainsInvalidDelimiter(numbers, delimiter);
        checkNumbersOnly(userInput);
        checkDelimitersOnly(numbers);
        checkContinuousDelimiter(numbers);
        checkCustomDelimiterNotNumber(delimiter);
    }

    private void checkContainsNegative(String userInput, String delimiter) {
        if (!delimiter.contains("-")) {
            if (userInput.contains("-")) {
                throw new IllegalArgumentException("음수가 입력되었습니다.");
            }
        }
    }

    private void checkContainsInvalidDelimiter(List<String> numbers, String delimiter) {
        for (String number : numbers) {
            if (!isNumeric(number)) {
                if (!delimiter.contains(number)) {
                    throw new IllegalArgumentException("구분자가 아닌 문자열이 입력되었습니다.");
                }
            }
        }
    }

    private boolean checkNumbersOnly(String userInput) {
        String[] split = userInput.split("");
        for (String s : split) {
            if (!isNumeric(s)) {
                return false;
            }
        }
        throw new IllegalArgumentException("숫자만 입력되었습니다.");
    }

    private void checkDelimitersOnly(List<String> numbers) {
        if (numbers.size() == 0) {
            throw new IllegalArgumentException("구분자만 입력되었습니다.");
        }
    }

    private void checkContinuousDelimiter(List<String> numbers) {
        for (String number : numbers) {
            if (number.isBlank()) {
                throw new IllegalArgumentException("구분자가 연속으로 입력되었습니다.");
            }
        }
    }

    private void checkCustomDelimiterNotNumber(String delimiter) {
        String[] delimiters = delimiter.split("|");
        for (String target : delimiters) {
            if (isNumeric(target)) {
                throw new IllegalArgumentException("커스텀 구분자에 숫자가 입력되었습니다.");
            }
        }
    }

    private boolean isNumeric(String target) {
        try {
            Double.parseDouble(target); // 숫자로 변환 시도
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
