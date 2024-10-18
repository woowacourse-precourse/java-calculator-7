package calculator.model;

public class Delimiter {

    private String delimiter;

    public Delimiter(String delimiter) {
        if (delimiter.equals(",|:")) {
            this.delimiter = delimiter;
            return;
        }
        validate(delimiter);
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }


    private void validate(String delimiter) {
        validateEmptyDelimiter(delimiter);
        validateSize(delimiter);
    }

    private void validateEmptyDelimiter(String delimiter) {
        if (delimiter == null || delimiter.isEmpty()) {
            throw new IllegalArgumentException("구분자는 빈 값일 수 없습니다.");
        }
    }

    private void validateSize(String delimiter) {
        if (delimiter.length() > 1) {
            throw new IllegalArgumentException("구분자는 한 개의 문자만 이용 가능합니다.");
        }
    }
}
