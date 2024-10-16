package calculator.domain;

import calculator.domain.exception.CalculatorException;
import calculator.domain.exception.ErrorMessage;
import calculator.domain.model.ExtractedInput;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterExtractor {
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final Pattern SINGLE_CHAR_DELIMITER_PATTERN = Pattern.compile("^//(.)\n");

    public static ExtractedInput extractDelimiters(String input) {
        if (!input.startsWith(CUSTOM_DELIMITER_PREFIX) || input.length() < 5) {
            return ExtractedInput.of(DEFAULT_DELIMITERS, input); // 기본 구분자 반환
        }

        Matcher matcher = SINGLE_CHAR_DELIMITER_PATTERN.matcher(input);

        if (!matcher.find()) {
            throw CalculatorException.from(ErrorMessage.INVALID_CUSTOM_DELIMITER_ERROR);
        }

        String customDelimiter = matcher.group(1);
        String remainingInput = input.substring(matcher.end()); // 구분자 선언 부분을 제거한 나머지 입력 값

        return ExtractedInput.of(DEFAULT_DELIMITERS + "|" + Pattern.quote(customDelimiter),
                remainingInput);
    }
}
