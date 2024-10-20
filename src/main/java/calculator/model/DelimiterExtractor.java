package calculator.model;

import calculator.exception.InvalidInputException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterExtractor {

    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\\\\n(.*)";
    private static final String INVALID_CUSTOM_DELIMITER_MESSAGE = "커스텀 구분자 형식이 올바르지 않습니다.";

    public String extractDelimiters(String input) {
        if (isCustomDelimiter(input)) {
            return parseCustomDelimiter(input) + "|" + DEFAULT_DELIMITERS;
        }
        return DEFAULT_DELIMITERS;
    }

    public String extractNumbers(String input) {
        if (isCustomDelimiter(input)) {
            return parseNumbers(input);
        }
        return input;
    }

    private boolean isCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    private String parseCustomDelimiter(String input) {
        Matcher matcher = getMatcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return handleSpecialDelimiters(customDelimiter);
        }
        throw new InvalidInputException(INVALID_CUSTOM_DELIMITER_MESSAGE);
    }

    private String parseNumbers(String input) {
        Matcher matcher = getMatcher(input);
        if (matcher.find()) {
            return matcher.group(2);
        }
        throw new InvalidInputException(INVALID_CUSTOM_DELIMITER_MESSAGE);
    }

    private Matcher getMatcher(String input) {
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);
        return pattern.matcher(input);
    }

    private String handleSpecialDelimiters(String delimiter) {
        if (delimiter.equals("-")) {
            return Pattern.quote(delimiter) + "|—";
        }
        return Pattern.quote(delimiter);
    }
}
