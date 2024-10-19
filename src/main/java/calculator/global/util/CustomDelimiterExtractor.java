package calculator.global.util;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiterExtractor extends DelimiterExtractor {

    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n";

    private static final Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);

    @Override
    protected String extractDelimiter(String input) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("유효하지 않은 입력입니다.");
    }

    @Override
    boolean isApplicable(String input) {
        return input.startsWith("//");
    }

}
