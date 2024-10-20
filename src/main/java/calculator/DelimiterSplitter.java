package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterSplitter {
    private final String str;
    private static final String BASIC_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final Pattern NEGATIVE_NUMBER_PATTERN = Pattern.compile(".*-\\d+.*");
    private static final Pattern NOT_NUMBER_PATTERN = Pattern.compile(".*[a-zA-Zㄱ-ㅎ가-힣].*");

    public DelimiterSplitter(String str) {
        this.str = str;
    }

    public String[] split() {
        if (str.isBlank()) {
            return new String[0];
        }

        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(str);
        if (matcher.find()) {
            return customDelimiterSplit(matcher);
        }

        return basicDelimiterSplit();
    }

    private String[] basicDelimiterSplit() {
        validateUserInput(str);
        return str.split(BASIC_DELIMITER);
    }

    private String[] customDelimiterSplit(Matcher matcher) {
        String customDelimiter = matcher.group(1);
        String numbers = matcher.group(2);
        validateUserInput(numbers);
        return numbers.isBlank() ? new String[0] : numbers.split(customDelimiter);
    }

    private static void validateUserInput(String str) {
        validateNegativeNum(str);
        validateNotNum(str);
    }

    private static void validateNegativeNum(String str) {
        if (NEGATIVE_NUMBER_PATTERN.matcher(str).matches()) {
            throw new UserInputException("[계산 실패] 음수는 입력할 수 없습니다.");
        }
    }
    private static void validateNotNum(String str) {
        if (NOT_NUMBER_PATTERN.matcher(str).matches()) {
            throw new UserInputException("[계산 실패] 숫자 외에 영어나 한글은 입력할 수 없습니다.");
        }
    }
}
