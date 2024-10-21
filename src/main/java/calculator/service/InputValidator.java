package calculator.service;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class InputValidator {
    // 커스텀 구분자 형식 검증을 위한 정규식
    private static final Pattern CUSTOM_FORMAT_PATTERN = Pattern.compile("//(.)\\\\n(.*)");

    // 숫자 검증을 위한 정규식 (1 이상의 정수)
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[1-9][0-9]*$");

    // 기본 구분자
    private static final String DEFAULT_DELIMITER = ",|:";

    public void validate(String input) {
        validateNotEmpty(input);

        if (input.startsWith("//")) {
            validateCustomFormat(input);
        } else {
            validateBasicFormat(input);
        }
    }

    private void validateNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 null이거나 비어있습니다.");
        }
    }

    private void validateCustomFormat(String input) {
        Matcher matcher = CUSTOM_FORMAT_PATTERN.matcher(input);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다. (예: //;\\\\n1;2;3)");
        }

        String delimiter = matcher.group(1);
        String numbers = matcher.group(2);

        // 커스텀 구분자 검증
        validateCustomDelimiter(delimiter);

        // 허용되지 않는 구분자 검사
        if (!numbers.matches("^[0-9,:" + Pattern.quote(delimiter) + "\\s]+$")) {
            throw new IllegalArgumentException("허용되지 않는 구분자가 포함되어 있습니다.");
        }
        // 숫자들 검증
        String[] numberTokens = numbers.split(Pattern.quote(delimiter) + "|" + DEFAULT_DELIMITER);
        validateNumbers(numberTokens);
    }

    private void validateBasicFormat(String input) {
        // 허용되지 않는 구분자 검사
        if (!input.matches("^[0-9,:\\s]+$")) {
            throw new IllegalArgumentException("허용되지 않는 구분자가 포함되어 있습니다.");
        }

        // 그 다음 숫자 검증
        String[] numbers = input.split(DEFAULT_DELIMITER);
        validateNumbers(numbers);
    }

    private void validateCustomDelimiter(String delimiter) {
        // 구분자가 숫자인 경우
        if (delimiter.matches("[0-9]")) {
            throw new IllegalArgumentException("구분자로 숫자를 사용할 수 없습니다.");
        }

        // 구분자가 기본 구분자와 중복되는 경우
        if (delimiter.matches("[,:]")) {
            throw new IllegalArgumentException("기본 구분자(,,:)는 커스텀 구분자로 사용할 수 없습니다.");
        }
    }

    private void validateNumbers(String[] numbers) {
        for (String number : numbers) {
            String trimmedNumber = number.trim();

            if (trimmedNumber.isEmpty()) {
                throw new IllegalArgumentException("빈 숫자가 포함되어 있습니다.");
            }

            if (!NUMBER_PATTERN.matcher(trimmedNumber).matches()) {
                throw new IllegalArgumentException("숫자는 1 이상의 정수여야 합니다: " + trimmedNumber);
            }
        }
    }
}