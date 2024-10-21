package calculator;

public class Delimiter {

    char delimiter;

    Delimiter(char delimiter) {
        this.delimiter = delimiter;
        validateDelimiter();

    }

    public char getDelimiter() {
        return delimiter;
    }

    private void validateDelimiter() {
        validateDelimiterIsPeriod();
        validateDelimiterIsDigit();
    }

    private void validateDelimiterIsPeriod() {
        if (delimiter == '.') {
            throw new IllegalArgumentException("커스텀 구분자에 '.'이 들어올 수 없습니다.");
        }
    }

    private void validateDelimiterIsDigit() {
        if (Character.isDigit(delimiter)) {
            throw new IllegalArgumentException("커스텀 구분자로 숫자는 사용할 수 없습니다.");
        }
    }
}
