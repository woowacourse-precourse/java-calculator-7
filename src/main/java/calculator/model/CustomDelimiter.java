package calculator.model;

import static calculator.model.BasicDelimiter.BASIC_DELIMITER_COLON;
import static calculator.model.BasicDelimiter.BASIC_DELIMITER_COMMA;
import static calculator.model.DelimiterGroup.WHITE_SPACE;

public class CustomDelimiter {

    public static final String CUSTOM_DELIMITER_PREFIX = "//";
    public static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    private final String value;
    private final String inputWithoutCustomDelimiter;

    public CustomDelimiter(String input) {
        if (!input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            this.value = null;
            this.inputWithoutCustomDelimiter = input;
            return;
        }

        int startIndex = CUSTOM_DELIMITER_PREFIX.length();
        int endIndex = input.indexOf(CUSTOM_DELIMITER_SUFFIX);

        validateExistDelimiterSuffix(endIndex);
        validateOnlyOneCustomDelimiter(input, endIndex);

        String delimiter = input.substring(startIndex, endIndex);
        this.inputWithoutCustomDelimiter = input.substring(endIndex + CUSTOM_DELIMITER_SUFFIX.length());

        validateNotEqBasicDelimiter(delimiter);
        validateIsWhiteSpaceEq(delimiter);
        this.value = delimiter;
    }

    public String getValue() {
        return value;
    }

    public String getInputWithoutCustomDelimiter() {
        return inputWithoutCustomDelimiter;
    }

    public boolean exists() {
        return value != null;
    }

    private void validateExistDelimiterSuffix(int index) {
        if (index == -1) {
            throw new IllegalArgumentException("커스텀 구분자는 " + CUSTOM_DELIMITER_SUFFIX + "로 끝나야 합니다.");
        }
    }

    private void validateOnlyOneCustomDelimiter(String input, int endIndex) {
        int index = input.substring(endIndex).indexOf(CUSTOM_DELIMITER_PREFIX);

        if (index != -1) {
            throw new IllegalArgumentException("커스텀 구분자는 오직 한개여야 합니다.");
        }
    }

    private void validateNotEqBasicDelimiter(String delimiter) {
        if (delimiter.equals(BASIC_DELIMITER_COLON) || delimiter.equals(BASIC_DELIMITER_COMMA)) {
            throw new IllegalArgumentException("커스텀 구분자는 기본 구분자와 같을 수 없습니다.");
        }
    }

    private void validateIsWhiteSpaceEq(String value) {
        if (value.equals(WHITE_SPACE)) {
            throw new IllegalArgumentException("커스텀 구분자는 공백이 될 수 없습니다.");
        }
    }
}
