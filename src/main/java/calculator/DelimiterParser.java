package calculator;

public class DelimiterParser {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    public String parse(String input) {
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            int delimiterIndex = findDelimiterIndex(input);
            String customDelimiter = input.substring(CUSTOM_DELIMITER_PREFIX.length(), delimiterIndex);
            if (isNumeric(customDelimiter)) {
                throw new IllegalArgumentException("숫자로 구분자를 지정할 수 없습니다.");
            }
            return join(customDelimiter);
        }
        return DEFAULT_DELIMITER;
    }

    public String extractNumbers(String input) {
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            int delimiterIndex = findDelimiterIndex(input);
            String inputNumber = input.substring(delimiterIndex + CUSTOM_DELIMITER_SUFFIX.length());
            return inputNumber;
        }
        return input;
    }

    public String[] split(String input, String delimiter) {
        return input.split(delimiter);
    }

    private int findDelimiterIndex(String input) {
        int delimiterIndex = input.indexOf(CUSTOM_DELIMITER_SUFFIX);
        if (delimiterIndex == -1) {
            throw new IllegalArgumentException("\"\\n\" 문자가 존재하지 않습니다.");
        }
        return delimiterIndex;
    }

    private String join(String customDelimiter) {
        return DEFAULT_DELIMITER + "|" + String.join("|", customDelimiter.split(""));
    }

    private boolean isNumeric(String str) {
        return str.matches("\\d+");  // 숫자로만 이루어졌는지 확인
    }
}
