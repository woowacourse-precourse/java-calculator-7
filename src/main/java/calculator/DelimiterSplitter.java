package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterSplitter {
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\\n(.*)";
    private static final String DEFAULT_DELIMITER_PATTERN = ",|;";

    public boolean isCustomDelimiter(String input) {
        char firstChar = input.charAt(0);
        return !Character.isDigit(firstChar);
    }

    public String[] splitByCustomDelimiter(String input) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        throw new IllegalArgumentException("커스텀 구분자를 찾을 수 없습니다. 올바른 형식은 //구분자\\n입니다.");
    }

    public String[] splitByDefaultDelimiter(String input) {
        return input.split(DEFAULT_DELIMITER_PATTERN);
    }

    public String[] split(String input) {
        if (isCustomDelimiter(input)) {
            return splitByCustomDelimiter(input);
        }
        return splitByDefaultDelimiter(input);
    }
}
