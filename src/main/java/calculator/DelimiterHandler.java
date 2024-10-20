package calculator;

import java.util.List;
import java.util.regex.Pattern;

public class DelimiterHandler {

    public static final String DELIMITER_PREFIX = "//";
    public static final String DELIMITER_SUFFIX = "\\n";
    public static final int DELIMITER_PREFIX_INDEX = 0;
    public static final int DELIMITER_SUFFIX_INDEX = 3;
    public static final int CUSTOM_DELIMITER_INDEX = 2;
    public static final String AND = "|";
    private static final String DEFAULT_DELIMITER = DefaultDelimiter.DEFAULT_DELIMITER.getDelimiter();

    public DelimiterAndNumber extractCustomDelimiterAndNumbers1(String input) {
        int startIndex = input.indexOf(DELIMITER_PREFIX);
        int endIndex = input.indexOf(DELIMITER_SUFFIX);
        if (startIndex == DELIMITER_PREFIX_INDEX && endIndex == DELIMITER_SUFFIX_INDEX) {
            String customDelimiter = input.substring(CUSTOM_DELIMITER_INDEX, endIndex);
            String numbersString = input.substring(endIndex + CUSTOM_DELIMITER_INDEX);
            String delimiters = DEFAULT_DELIMITER + AND + Pattern.quote(customDelimiter);
            return new DelimiterAndNumber(delimiters, numbersString);
        } else {
            if (DELIMITER_SUFFIX_INDEX != endIndex) {
                throw new IllegalArgumentException("커스텀 구분자는 한글자이어야 합니다.");
            }
            throw new IllegalArgumentException("잘못된 입력입니다. 다시 입력해주세요.");
        }
    }

    public void validateDefaultDelimiter(String input) {
        List<Character> invalidChars = input.chars()
                .mapToObj(c -> (char) c)
                .filter(this::isInvalidChar)
                .toList();
        if (hasInvalidDelimiter(invalidChars)) {
            throw new IllegalArgumentException(
                    String.format("(%s)에서는 허용되지 않는 구분자가 발견되었습니다. (%s)", input, invalidChars)
            );
        }
    }

    private boolean isInvalidChar(char c) {
        return !(Character.isDigit(c) || DEFAULT_DELIMITER.indexOf(c) != -1);
    }

    private boolean hasInvalidDelimiter(List<Character> invalidChars) {
        return !invalidChars.isEmpty();
    }
}
