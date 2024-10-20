package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterSplitter {
    private final String str;
    private static final String BASIC_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";

    public DelimiterSplitter(String str) {
        this.str = str;
    }

    public String[] split() {
        validateUserInput(str);

        if (str.isBlank()) {
            return new String[0];
        }
        if (Pattern.matches(CUSTOM_DELIMITER, str)) {
            return customDelimiterSplit();
        }
        return basicDelimiterSplit();
    }

    private String[] basicDelimiterSplit() {
        return str.split(BASIC_DELIMITER);
    }

    private String[] customDelimiterSplit() {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(str);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String numbers = matcher.group(2);
            return numbers.isBlank() ? new String[0] : numbers.split(customDelimiter);
        }
        return new String[0];
    }

    private static void validateUserInput(String str) {
        if (str.matches(".*-\\d+.*") || str.matches("//(.)\n(.*-\\d+.*)")) {
            throw new UserInputException("[계산 실패] 음수는 입력할 수 없습니다.");
        }
    }
}
