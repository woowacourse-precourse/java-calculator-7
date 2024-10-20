package calculator.validator;

import java.math.BigDecimal;
import java.util.List;

public class InputValidator {

    private static final String DELIMITER_PREFIX = "//";
    private static final String DELIMITER_SUFFIX = "\\n";

    public void validateCustomDelimiterFormat(String input) {
        if (!input.contains(DELIMITER_SUFFIX)) {
            throw new IllegalArgumentException("커스텀 구분자의 지정 형식이 잘못되었습니다.");
        }
    }

    public void validateCustomDelimiterSpecificIndex(String input) {
        if (input.contains(DELIMITER_PREFIX) && input.indexOf(DELIMITER_PREFIX) != 0) {
            throw new IllegalArgumentException("커스텀 구분자는 입력 시작 위치에서만 지정할 수 있습니다.");
        }
    }

    public void validateSingleCustomDelimiter(String input) {
        int firstDelimiterIndex = input.indexOf(DELIMITER_PREFIX);
        int secondDelimiterIndex = input.indexOf(DELIMITER_PREFIX, firstDelimiterIndex + 2);

        if (secondDelimiterIndex != -1) {
            throw new IllegalArgumentException("커스텀 구분자는 한 번만 지정할 수 있습니다.");
        }
    }

    public void validateCustomDelimiterExtraction(boolean isDelimiterFound) {
        if (!isDelimiterFound) {
            throw new IllegalArgumentException("알 수 없는 오류로 인한 구분자 추출 실패");
        }
    }

    public void validateCustomDelimiterIsCharacter(String customDelimiterPart) {
        if (customDelimiterPart.length() != 1) {
            throw new IllegalArgumentException("커스텀 구분자는 공백, 문자열이 아닌 하나의 문자여야 합니다.");
        }
    }

    public void validateDelimiterIsNotDigit(Character findCustomDelimiter) {
        if (Character.isDigit(findCustomDelimiter)) {
            throw new IllegalArgumentException("커스텀 구분자는 숫자가 될 수 없습니다.");
        }
    }

    public void validateDelimiterIsNotDotOrDash(Character findCustomDelimiter) {
        if (findCustomDelimiter == '.' || findCustomDelimiter == '-') {
            throw new IllegalArgumentException("커스텀 구분자는 '.', '-' 이 될 수 없습니다.");
        }
    }

    public void validateInvalidDelimiters(String input, List<Character> validDelimiters) {
        input.chars()
                .mapToObj(ch -> (char) ch)
                .filter(ch -> !Character.isDigit(ch) && !validDelimiters.contains(ch) && ch != '-' && ch != '.')
                .findFirst()
                .ifPresent(invalidDelimiter -> {
                    throw new IllegalArgumentException("올바르지 않은 구분자 혹은 입력값이 있습니다.");
                });
    }

    public void validateNumber(String input) {
        try {
            BigDecimal number = new BigDecimal(input);
            if (number.compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("양수를 입력해주세요.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바르지 않은 구분자 혹은 입력값이 있습니다.");
        }

    }
}
