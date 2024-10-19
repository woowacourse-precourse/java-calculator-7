package calculator;

import java.util.List;

public class CustomDelimiterValidator {

    private final CustomDelimiterFormatParser formatParser;

    public CustomDelimiterValidator() {
        this.formatParser = new CustomDelimiterFormatParser();
    }

    public void validate(String input) {
        if (!formatParser.isCheckedStart(input)) {
            return;
        }

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
