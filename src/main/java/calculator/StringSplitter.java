package calculator;

public class StringSplitter {
    private static final String BASIC_DELIMITER = ",|:";
    private static final String NO_DELIMITER_ERROR = "입력 문자열에 구분자가 없습니다.";

    public String[] split(String input) {
        validateBasicDelimiter(input);
        return input.split(BASIC_DELIMITER);
    }

    private void validateBasicDelimiter(String input) {
        if (!input.contains(",") && !input.contains(":")) {
            throw new IllegalArgumentException(NO_DELIMITER_ERROR);
        }
    }
}
