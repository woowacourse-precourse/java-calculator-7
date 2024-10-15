package calculator.domain;

import calculator.domain.exception.CalculatorException;
import calculator.domain.exception.ErrorMessage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterExtractor {
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final Pattern SINGLE_CHAR_DELIMITER_PATTERN = Pattern.compile("^//(.)\n");

    public String extractDelimiters(String input) {
        if (!input.startsWith(CUSTOM_DELIMITER_PREFIX) || input.length() < 5) {
            return DEFAULT_DELIMITERS; // 기본 구분자 반환
        }

        Matcher matcher = SINGLE_CHAR_DELIMITER_PATTERN.matcher(input);

        if (!matcher.find()) {
            throw CalculatorException.from(ErrorMessage.INVALID_CUSTOM_DELIMITER_ERROR);
        }

        String customDelimiter = matcher.group(1);
        return DEFAULT_DELIMITERS + "|" + Pattern.quote(customDelimiter); // 커스텀 구분자 추가 후 반환
    }
}
