package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Parser {

    private static final String DEFAULT_DELIMITER_COMMA = ",";
    private static final String DEFAULT_DELIMITER_COLON = ":";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\n";

    public static String processCustomDelimiter(String input, List<String> delimiters) {
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            int delimiterEndIndex = input.indexOf(CUSTOM_DELIMITER_SUFFIX);
            if (delimiterEndIndex == -1)
                throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");

            String customDelimiter = input.substring(CUSTOM_DELIMITER_PREFIX.length(), delimiterEndIndex);
            delimiters.add(Pattern.quote(customDelimiter));

            return input.substring(delimiterEndIndex + 1);
        }

        return input;
    }

    public static List<String> getDefaultDelimiters() {
        List<String> delimiters = new ArrayList<>();
        delimiters.add(DEFAULT_DELIMITER_COMMA);
        delimiters.add(DEFAULT_DELIMITER_COLON);

        return delimiters;
    }
}
