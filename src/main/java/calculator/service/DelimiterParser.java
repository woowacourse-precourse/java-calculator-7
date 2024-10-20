package calculator.service;

import calculator.dto.CalculatorRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterParser {

    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("^//(.*)\\\\n");
    private static final String DEFAULT_DELIMITERS = "[,:]";

    public static CalculatorRequest parseDelimiters(String input) {
        if (!input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            return CalculatorRequest.of(DEFAULT_DELIMITERS, input);
        }

        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException("잘못된 구분자 형식입니다. 커스텀 구분자는 '//'로 시작하고, '\\n'으로 끝나야 합니다.");
        }
        String customDelimiter = matcher.group(1);
        if (customDelimiter.isEmpty()) {
            throw new IllegalArgumentException("커스텀 구분자가 존재하지 않습니다.");
        }

        String calculation = input.substring(matcher.end());
        return CalculatorRequest.of(Pattern.quote(customDelimiter), calculation);
    }
}
