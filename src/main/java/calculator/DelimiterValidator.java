package calculator;

public class DelimiterValidator {
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private static final int CUSTOM_DELIMITER_LIMIT = 1;
    private static final String DEFAULT_DELIMITERS = ",:";
    private String customDelimiter = "";

    public String getDefaultDelimiters() {
        return DEFAULT_DELIMITERS;
    }

    public String getCustomDelimiter() {
        return customDelimiter;
    }

    public String getAllDelimiters() {
        return DEFAULT_DELIMITERS + customDelimiter;
    }

    public int getDelimiterCommandLength() {
        int length = CUSTOM_DELIMITER_PREFIX.length();
        length += customDelimiter.length();
        length += CUSTOM_DELIMITER_SUFFIX.length();

        return length;
    }

    private boolean hasCustomDelimiter(String input) {
        int start = input.indexOf(CUSTOM_DELIMITER_PREFIX);
        int end = input.indexOf(CUSTOM_DELIMITER_SUFFIX);

        if (start != -1 && end != -1) {
            return true;
        }
        return false;
    }

    private void validateCommand(String input) {
        int start = input.indexOf(CUSTOM_DELIMITER_PREFIX);
        int end = input.indexOf(CUSTOM_DELIMITER_SUFFIX);

        if (end != -1 && start > end) {
            throw new IllegalArgumentException("커스텀 구분자 지정 명령이 잘못되었습니다. 올바른 명령:" + CUSTOM_DELIMITER_PREFIX + "[구분자]" + CUSTOM_DELIMITER_SUFFIX);
        }
        if (start != 0 && end != -1) {
            throw new IllegalArgumentException("커스텀 구분자는 문자열 앞부분에서 지정해야 합니다.");
        }
    }

    private void validateDelimiter(String delimiter) {
        if (delimiter.length() > CUSTOM_DELIMITER_LIMIT) {
            throw new IllegalArgumentException("커스텀 구분자는 문자 " + CUSTOM_DELIMITER_LIMIT + "개까지만 지정 가능합니다. 입력한 구분자: " + delimiter);
        }
        if (delimiter.isEmpty()) {
            throw new IllegalArgumentException("커스텀 구분자를 빈 문자열로 지정할 수 없습니다.");
        }
        for (char c : delimiter.toCharArray()) {
            if (Character.isDigit(c)) {
                throw new IllegalArgumentException("커스텀 구분자는 숫자로 지정할 수 없습니다. 입력한 구분자: " + delimiter);
            }
        }
    }

    public void setCustomDelimiter(String input) {
        //커스텀 구분자 명령 유효 검사 수행 후
        //커스텀 구분자 지정, 없을 경우 빈 문자열 ""
        if (!hasCustomDelimiter(input)) {
            return;
        }
        validateCommand(input);

        String delimiter = "";

        int start = input.indexOf(CUSTOM_DELIMITER_PREFIX);
        int end = input.indexOf(CUSTOM_DELIMITER_SUFFIX);
        if (start != -1 && end != -1) {
            delimiter = input.substring(start + CUSTOM_DELIMITER_PREFIX.length(), end);
        }
        validateDelimiter(delimiter);

        this.customDelimiter = delimiter;
    }
}
