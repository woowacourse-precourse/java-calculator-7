package calculator.model;

import calculator.util.NumberValidator;

import java.util.regex.Matcher;

import static calculator.constant.DelimiterConstants.DEFAULT_DELIMITER_REGEX;
import static calculator.constant.ErrorMessages.CUSTOM_DELIMITER_NOT_FOUND;

public class CustomValidator implements Validator {

    private final Matcher matcher;

    public CustomValidator(Matcher matcher) {
        this.matcher = matcher;
    }

    @Override
    public ParsedInput validate(String input) {
        String delimiter = extractDelimiter(); // 커스텀 구분자 추출
        String numbersWithDelimiter = matcher.group(2); // 숫자 문자열 추출

        String delimiterRegex = buildDelimiterRegex(delimiter);
        String[] numbers = numbersWithDelimiter.split(delimiterRegex);

        NumberValidator.validateNumbers(numbers);

        return new ParsedInput(delimiterRegex, numbersWithDelimiter);
    }

    private String buildDelimiterRegex(String delimiter) {
        return DEFAULT_DELIMITER_REGEX.substring(0, DEFAULT_DELIMITER_REGEX.length() - 1)
                + delimiter + "]";
    }

    private String extractDelimiter() {
        String delimiter = matcher.group(1);
        if (delimiter.isEmpty()) {
            throw new IllegalArgumentException(CUSTOM_DELIMITER_NOT_FOUND);
        }
        return delimiter;
    }
}
