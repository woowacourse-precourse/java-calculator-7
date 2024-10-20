package calculator.service;

public class CustomDelimiterChecker {

    private final static int DELIMITER_PREFIX_START_INDEX = 0;
    private final static int DELIMITER_PREFIX_END_INDEX = 2;
    private final static int DELIMITER_TERMINATOR_START_INDEX = 3;
    private final static int DELIMITER_TERMINATOR_END_INDEX = 5;

    public void checkCustomDelimiterRule(String input) {
        if (!input.substring(DELIMITER_PREFIX_START_INDEX, DELIMITER_PREFIX_END_INDEX).equals("//")
                || !input.substring(DELIMITER_TERMINATOR_START_INDEX, DELIMITER_TERMINATOR_END_INDEX).equals("\\n")) {
            throw new IllegalArgumentException("커스텀 구분자가 규칙에 맞지 않습니다.");
        }
    }

    public void checkCustomDelimiter(String input) {
        if (Character.isDigit(input.charAt(2))) {
            throw new IllegalArgumentException("커스텀 구분자는 문자여야 합니다.");
        }
    }
}

