package calculator.service;

import calculator.util.CustomDelimiterFormatParser;
import java.util.List;

public class InputValidator {

    private final CustomDelimiterFormatParser formatParser;

    public InputValidator() {
        this.formatParser = new CustomDelimiterFormatParser();
    }

    public void validate(String input) {
        if (input == null || input.isEmpty()) {
            return;
        }

        checkBlank(input);

        if (formatParser.isCheckedStart(input)) {
            validateCustomDelimiter(input);
        } else {
            validateBasicDelimiter(input);
        }
    }

    private void checkBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("입력값은 공백일 수 없습니다.");
        }
    }

    private void validateBasicDelimiter(String input) {
        if (!isCheckedBasicDelimiter(input)) {
            throw new IllegalArgumentException("기본 구분자가 포함되어 있지 않습니다.");
        }
    }

    private boolean isCheckedBasicDelimiter(String input) {
        List<String> basicDelimiters = Delimiter.getBasicDelimiters();

        return basicDelimiters.stream()
                .anyMatch(input::contains);
    }

    private void validateCustomDelimiter(String input) {
        if (!formatParser.isCheckedFormat(input)) {
            throw new IllegalArgumentException("커스텀 구분자를 사용하기 위한 형식이 아닙니다.");
        }

        List<String> customDelimiters = formatParser.splitDelimiterSection(input);
        if (isCheckedInvalidDelimiter(customDelimiters)) {
            throw new IllegalArgumentException("사용할 수 없는 구분자가 포함되어있습니다.");
        }
    }

    private boolean isCheckedInvalidDelimiter(List<String> customDelimiters) {
        List<String> invalidDelimiters = Delimiter.getInvalidCustomDelimiters();

        return customDelimiters.stream()
                .anyMatch(customDelimiter ->
                        invalidDelimiters.stream()
                                .anyMatch(customDelimiter::matches)
                );
    }

}
