package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.*?)\\\\n";
    static int THE_NUMBER_OF_CUSTOM_DELIMITER = 1;

    private String input;

    public Delimiter(String input) {
        this.input = input;
    }

    public String[] extractDelimiterAndNumber() {
        String delimiters = getDelimiter();
        return splitByDelimiter(delimiters);
    }

    public String getDelimiter() {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(input);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            input = input.substring(matcher.end());

            if (customDelimiter.isEmpty()) {
                return DEFAULT_DELIMITER;
            }

            if (customDelimiter.length() == THE_NUMBER_OF_CUSTOM_DELIMITER) {
                return "[" + Pattern.quote(customDelimiter) + "]|" + DEFAULT_DELIMITER;
            }

            throw new IllegalArgumentException("커스텀 구분자는" + THE_NUMBER_OF_CUSTOM_DELIMITER + "개의 문자만 지정할 수 있습니다.");
        }
        return DEFAULT_DELIMITER;
    }

    public String[] splitByDelimiter(String delimiters) {
        return input.split(delimiters);
    }

}
