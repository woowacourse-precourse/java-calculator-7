package calculator.model;

import static calculator.model.enums.ExceptionMessage.DELIMITER_SIZE_EXCEPTION;
import static calculator.model.enums.ExceptionMessage.EMPTY_DELIMITER_EXCEPTION;
import static calculator.model.enums.ParsingPattern.DEFAULT_DELIMITER_PATTERN;

// 구분자를 저장해 놓는 객체
public class Delimiter {

    private final String delimiter;

    private static final int DELIMITER_SIZE = 1;

    // 분리되어 들어온 구분자가 기본구분자 패턴과 일치하면 검증하지 않고 일치하지 않으면 검증 시작
    public Delimiter(String delimiter) {
        if (delimiter.equals(DEFAULT_DELIMITER_PATTERN.getPattern())) {
            this.delimiter = delimiter;
            return;
        }
        validate(delimiter);
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }

    // 전체적인 검증 로직 수행
    private void validate(String delimiter) {
        validateEmptyDelimiter(delimiter);
        validateSize(delimiter);
    }

    // 구분자가 빈 값인지 검증
    private void validateEmptyDelimiter(String delimiter) {
        if (delimiter == null || delimiter.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_DELIMITER_EXCEPTION.getMessage());
        }
    }

    // 구분자가 문자 하나로만 이루어져있는지 검증
    private void validateSize(String delimiter) {
        if (delimiter.length() != DELIMITER_SIZE) {
            throw new IllegalArgumentException(DELIMITER_SIZE_EXCEPTION.getMessage());
        }
    }
}
