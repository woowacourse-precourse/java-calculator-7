package calculator.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringDelimiterParser implements Parser {

    private final String defaultDelimiters;
    private final String customRegex;

    public StringDelimiterParser(DelimiterConfig config) {
        this.defaultDelimiters = config.getDefaultDelimiters();
        this.customRegex = config.getCustomRegex();
    }

    @Override
    public String[] parseToNumberStrings(String input) {
        String correctInput = trimInputString(input);
        String delimiters = defaultDelimiters;
        String numbers = correctInput;

        if (correctInput.isBlank()) {
            return new String[0];
        }

        Matcher matcher = Pattern.compile(customRegex).matcher(correctInput);
        if (matcher.matches()) {
            String customDelimiter = matcher.group(1);
            validateCustomDelimiter(customDelimiter);
            delimiters = delimiters + "|" + Pattern.quote(customDelimiter);
            numbers = matcher.group(2);
        }

        return numbers.split(delimiters);
    }

    private void validateCustomDelimiter(String delimiter) {
        validateEmptyDelimiter(delimiter);
        validateDelimiterCharacters(delimiter);
        validateNumericDelimiter(delimiter);
    }

    private void validateEmptyDelimiter(String delimiter) {
        if (delimiter.isEmpty()) {
            throw new IllegalArgumentException("커스텀 구분자는 공백을 사용할 수 없습니다.");
        }
    }

    private void validateDelimiterCharacters(String delimiter) {
        if (delimiter.contains(",") || delimiter.contains(":")) {
            throw new IllegalArgumentException("커스텀 구분자는 ',' 와 ';' 을 사용할 수 없습니다.");
        }
    }

    private void validateNumericDelimiter(String delimiter) {
        for (char c : delimiter.toCharArray()) {
            if (Character.isDigit(c)) {
                throw new IllegalArgumentException("커스텀 구분자는 숫자를 포함할 수 없습니다.");
            }
        }
    }

    private String trimInputString(String input) {
        return input.trim();
    }
}
