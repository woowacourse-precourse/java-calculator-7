package calculator.numbercalculator.delimiter;

public record Delimiter(String value) {
    private static final int DELIMITER_SIZE = 1;

    public Delimiter {
        validateSize(value);
    }

    private void validateSize(String symbol) {
        if (isNull(symbol) || isInvalidSize(symbol)) {
            throw new IllegalArgumentException("구분자는 단일 문자여야 합니다.");
        }
    }

    private boolean isNull(String symbol) {
        return symbol == null;
    }

    private boolean isInvalidSize(String symbol) {
        return symbol.length() != DELIMITER_SIZE;
    }

    public int size() {
        return DELIMITER_SIZE;
    }
}
