package calculator.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static final String DEFAULT_DELIMITERS = ",|:";

    public String[] parse(String input) {

        // 빈 문자열 혹은 null 값이 들어올 경우
        if (input == null || input.isEmpty()) {
            // 0 반환해야 함
            return new String[]{"0"};
        }

        String customDelimiterPattern = "//(.)\\\\n(.*)";
        Pattern pattern = Pattern.compile(customDelimiterPattern);
        Matcher matcher = pattern.matcher(input);

        String delimiters = DEFAULT_DELIMITERS;
        String numbers = input;

        if (matcher.matches()) {
            // 커스텀 구분자가 존재하는 경우
            String customDelimiter = matcher.group(1);
            numbers = matcher.group(2);
            delimiters = DEFAULT_DELIMITERS + "|" + Pattern.quote(customDelimiter);
        }

        // 기본 구분자와 커스텀 구분자를 혼용하여 분리
        return numbers.split(delimiters);
    }
}
