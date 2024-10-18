package calculator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterParser {
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n";

    public static String parseCustomDelimiter(String expression) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(expression);
        if (matcher.find()) {
            // 커스텀 구분자를 추출하여 반환
            return matcher.group(1);
        }
        return "";
    }
}
