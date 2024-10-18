package calculator.util;

import static calculator.constant.ErrorMessage.NUMBER_CANNOT_DELIMITER;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterParser {
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.+?)\n";
    private static final String NUMBER_PATTERN = "[0-9]"; // 숫자를 나타내는 정규식

    public static String parseCustomDelimiters(String expression) {
        StringBuilder delimiters = new StringBuilder();
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(expression);

        while (matcher.find()) {
            String delimiter = matcher.group(1);

            if (delimiter.matches(NUMBER_PATTERN)) {
                throw new IllegalArgumentException(NUMBER_CANNOT_DELIMITER);
            }

            if (delimiters.length() > 0) {
                delimiters.append("|");
            }

            delimiters.append(Pattern.quote(delimiter));
        }
        return delimiters.toString();
    }
}
