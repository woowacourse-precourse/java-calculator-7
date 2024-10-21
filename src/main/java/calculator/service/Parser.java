package calculator.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\\\\n(.*)";
    private static final String OR = "|";
    private static final String ZERO = "0";
    private static final int START_NUM = 1;
    private static final int END_NUM = 2;

    public String[] parse(String input) {

        // 빈 문자열 혹은 null 값이 들어올 경우
        if (input == null || input.isEmpty()) {
            // 0 반환해야 함
            return new String[]{ZERO};
        }

        String customDelimiterPattern = CUSTOM_DELIMITER;
        Pattern pattern = Pattern.compile(customDelimiterPattern);
        Matcher matcher = pattern.matcher(input);

        String delimiters = DEFAULT_DELIMITERS;
        String numbers = input;

        if (matcher.matches()) {
            // 커스텀 구분자가 존재하는 경우
            String customDelimiter = matcher.group(START_NUM);
            numbers = matcher.group(END_NUM);
            delimiters = DEFAULT_DELIMITERS + OR + Pattern.quote(customDelimiter);
        }

        // 기본 구분자와 커스텀 구분자를 혼용하여 분리
        return numbers.split(delimiters);
    }
}
