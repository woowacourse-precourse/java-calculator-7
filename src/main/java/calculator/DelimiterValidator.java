package calculator;

public class DelimiterValidator {
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private static final int CUSTOM_DELIMITER_LIMIT = 1;

    public boolean hasCustomDelimiter(String input) {
        int start = input.indexOf(CUSTOM_DELIMITER_PREFIX);
        int end = input.indexOf(CUSTOM_DELIMITER_SUFFIX);

        if (end != -1 && start > end) {
            throw new IllegalArgumentException("커스텀 구분자 지정 명령이 잘못되었습니다. 올바른 명령:" + CUSTOM_DELIMITER_PREFIX + "[구분자]" + CUSTOM_DELIMITER_SUFFIX);
        }
        if (start != -1 && end != -1) {
            return true;
        }
        return false;
    }

    public void validateDelimiter(String customDelimiter) {
        if (customDelimiter.length() > CUSTOM_DELIMITER_LIMIT) {
            throw new IllegalArgumentException("커스텀 구분자는 문자 " + CUSTOM_DELIMITER_LIMIT + "개까지만 지정 가능합니다. 입력한 구분자: " + customDelimiter);
        }
        for (char c : customDelimiter.toCharArray()) {
            if (Character.isDigit(c)) {
                throw new IllegalArgumentException("커스텀 구분자는 숫자로 지정할 수 없습니다. 입력한 구분자: " + customDelimiter);
            }
        }
    }

    public String getCustomDelimiter(String input) {
        //커스텀 구분자가 있다면 반환, 없다면 "" 반환
        String delimiter = "";

        if (!hasCustomDelimiter(input)) {
            return delimiter;
        }

        int start = input.indexOf(CUSTOM_DELIMITER_PREFIX);
        int end = input.indexOf(CUSTOM_DELIMITER_SUFFIX);

        if (start != -1 && end != -1) {
            delimiter = input.substring(start + CUSTOM_DELIMITER_PREFIX.length(), end);
        }

        validateDelimiter(delimiter);
        return delimiter;
    }
}
