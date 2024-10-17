package calculator.model;

import static calculator.util.Constant.DEFAULT_DELIMITERS;

import java.util.regex.Pattern;

public class InputValidator {

    public boolean isEmptyOrNull(String input) {
        return input == null || input.isEmpty();
    }

    public void checkNegativeNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
        }
    }

    public String[] splitInput(String input) {
        String[] parts = input.split("\n", 2);
        if (parts.length != 2) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다: 계산 될 문자가 없습니다.:" + input);
        }
        return parts;
    }

    public void validateCustomDelimiter(String customDelimiter) {
        if (containsNumbers(customDelimiter)) {
            throw new IllegalArgumentException("잘못된 커스텀 구분자: 구분자는 숫자와 문자가 섞여 있거나 숫자로만 이루어질 수 없습니다." + customDelimiter);
        }
    }

    public void validateInputContent(String numbersPart, String customDelimiter) {
        if (containsInvalidDelimiter(numbersPart, customDelimiter)) {
            throw new IllegalArgumentException("잘못된 입력입니다: 문자열에 커스텀 구분자 외에 다른 구분자가 포함되었습니다." + numbersPart);
        }
    }

    public void validateDefaultDelimiterContent(String input) {
        if (containsInvalidDefaultDelimiter(input)) {
            throw new IllegalArgumentException("잘못된 입력입니다: 기본 구분자 외의 다른 구분자가 포함되었습니다." + input);
        }
    }

    private boolean containsNumbers(String customDelimiter) {
        return customDelimiter.matches(".*\\d.*");
    }

    private boolean containsInvalidDelimiter(String part, String customDelimiter) {
        String invalidDelimitersRegex = "[^" + Pattern.quote(customDelimiter) + "\\d]";
        return part.matches(invalidDelimitersRegex);
    }

    private boolean containsInvalidDefaultDelimiter(String input) {
        String invalidDefaultDelimitersRegex = "[^" + DEFAULT_DELIMITERS + "\\d]";
        return Pattern.compile(invalidDefaultDelimitersRegex).matcher(input).find();
    }
}
