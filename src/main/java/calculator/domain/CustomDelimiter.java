package calculator.domain;

public class CustomDelimiter {

    private static final int FIX_SIZE = 1;
    private static final String NUMBER_TYPE = "\\d";

    private final String delimiter;

    public CustomDelimiter(String delimiter) {
        validateLength(delimiter);
        validateType(delimiter);
        validateIsDefault(delimiter);
        this.delimiter = delimiter;
    }

    private void validateLength(String delimiter) {
        if (delimiter.length() != FIX_SIZE) {
            throw new IllegalArgumentException("커스텀 구분자는 " + FIX_SIZE + "글자만 입력해야 합니다.");
        }
    }

    private void validateType(String delimiter) {
        if (delimiter.matches(NUMBER_TYPE)) {
            throw new IllegalArgumentException("커스텀 구분자에 숫자는 입력할 수 없습니다.");
        }
    }

    private void validateIsDefault(String delimiter) {
        if (delimiter.equals(DefaultDelimiter.FIRST.getDelimiter()) || delimiter.equals(
                DefaultDelimiter.SECOND.getDelimiter())) {
            throw new IllegalArgumentException("기본 구분자는 커스텀으로 사용할 수 없습니다.");
        }
    }
}