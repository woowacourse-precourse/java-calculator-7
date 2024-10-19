package calculator.domain;

public class CustomDelimiter {

    private static final int FIX_SIZE = 1;

    private final String delimiter;

    public CustomDelimiter(String delimiter) {
        validateLength(delimiter);
        this.delimiter = delimiter;
    }

    private void validateLength(String delimiter) {
        if (delimiter.length() != FIX_SIZE) {
            throw new IllegalArgumentException("커스텀 구분자는 " + FIX_SIZE + "글자만 입력해야 합니다.");
        }
    }
}