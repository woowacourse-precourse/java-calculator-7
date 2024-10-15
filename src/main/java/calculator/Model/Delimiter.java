package calculator.Model;

public class Delimiter {
    private final String delimiter;

    public Delimiter(String delimiter) {
        validateDelimiter(delimiter);
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return this.delimiter;
    }

    private void validateDelimiter(String delimiter) {
        isNull(delimiter);
        isDigit(delimiter);
    }

    private void isNull(String delimiter) {
        if (delimiter.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void isDigit(String delimiter) {
        if (delimiter.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }
    }
}
