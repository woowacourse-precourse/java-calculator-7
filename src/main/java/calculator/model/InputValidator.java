package calculator.model;

import static calculator.util.Constant.DEFAULT_DELIMITERS;

import java.util.regex.Pattern;

public class InputValidator {

    public void validateEmptyOrNull(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다. 빈 문자열 또는 null 입력은 허용되지 않습니다.");
        }
    }

    public void checkNegativeNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
        }
    }

    public String[] splitInput(String input) {
        input = input.replace("\\n", "\n");
        String[] parts = input.split("\n", 2);
        if (parts.length != 2) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다: 계산 될 문자가 없습니다.:" + input);
        }
        return parts;
    }

    public void validateCustomDelimiter(String customDelimiter) {

        if (customDelimiter == null || customDelimiter.trim().isEmpty()) {
            throw new IllegalArgumentException("잘못된 커스텀 구분자: 구분자는 빈 값일 수 없습니다: " + customDelimiter);
        }

        if (containsNumbers(customDelimiter) || containsWhitespace(customDelimiter)) {
            throw new IllegalArgumentException("잘못된 커스텀 구분자: 구분자는 숫자나 공백을 포함할 수 없습니다: " + customDelimiter);
        }
    }

    public void validateInputContent(String input, String customDelimiter) {
        if (containsInvalidDelimiter(input, customDelimiter)) {
            throw new IllegalArgumentException("잘못된 입력입니다: 문자열에 커스텀 구분자 외에 다른 구분자가 포함되었습니다." + input);
        }
    }

    public void validateDefaultDelimiterContent(String input) {
        if (containsInvalidDefaultDelimiter(input)) {
            throw new IllegalArgumentException("잘못된 입력입니다: 기본 구분자 외의 다른 구분자가 포함되었습니다." + input);
        }
    }

    public String[] splitByDelimiter(String input, String delimiter) {

        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다. 빈 문자열 또는 null 입력은 허용되지 않습니다.");
        }

        if (!input.contains(delimiter) && input.contains(" ")) {
            throw new IllegalArgumentException("잘못된 입력: 값에 공백이 포함될 수 없습니다.");
        }

        if (!input.contains(delimiter)) {
            return new String[]{input};
        }
        return input.split(Pattern.quote(delimiter));
    }

    private boolean containsNumbers(String customDelimiter) {
        return customDelimiter.matches(".*\\d.*");
    }

    private boolean containsWhitespace(String customDelimiter) {
        return customDelimiter.contains(" ") || customDelimiter.matches(".*\\s.*");
    }

    private boolean containsInvalidDelimiter(String input, String customDelimiter) {
        String invalidDelimitersRegex = "[^" + Pattern.quote(customDelimiter) + "\\d]";
        //return part.matches(invalidDelimitersRegex);
        return Pattern.compile(invalidDelimitersRegex).matcher(input).find();
    }

    private boolean containsInvalidDefaultDelimiter(String input) {
        String invalidDefaultDelimitersRegex = "[^" + DEFAULT_DELIMITERS + "\\d]";
        return Pattern.compile(invalidDefaultDelimitersRegex).matcher(input).find();
    }
}
