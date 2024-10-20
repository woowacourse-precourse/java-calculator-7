package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterParser {

    private static final String CUSTOM_DELIMITER_PATTERN = "//(.*)\n(.*)";
    private static final String DEFAULT_DELIMITERS = "[,|:]";

    public static List<String> parse(String input) {
        if (input.startsWith("//")) {
            return parseWithCustomDelimiter(input);
        }
        return parseWithDefaultDelimiters(input);
    }

    private static List<String> parseWithCustomDelimiter(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);
        if (matcher.matches()) {
            String customDelimiter = Pattern.quote(matcher.group(1));
            String numbers = matcher.group(2);
            return split(numbers, customDelimiter);
        }
        throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
    }

    private static List<String> parseWithDefaultDelimiters(String input) {
        return split(input, DEFAULT_DELIMITERS);
    }

    private static List<String> split(String input, String delimiters) {
        return Arrays.asList(input.split(delimiters));
    }
}
