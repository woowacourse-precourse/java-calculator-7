package calculator.domain.number;

public class Number {

    private final int value;

    public Number(String value) {
        this.value = validate(value);
    }

    private int validate(String value) {
        if (isBlank(value)) {
            return 0;
        }
        return validateNumber(value);
    }

    private int validateNumber(String value) {
        if (isNotNumeric(value)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(value);
    }

    private boolean isBlank(String value) {
        return value.isBlank();
    }

    private boolean isNotNumeric(String value) {
        return !value.matches("\\d+");
    }
}
