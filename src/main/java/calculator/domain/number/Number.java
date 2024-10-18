package calculator.domain.number;

public class Number {

    private final double value;

    public Number(double value) {
        this.value = value;
    }

    public Number(String value) {
        this.value = parse(value);
    }

    public double getValue() {
        return value;
    }

    private Double parse(String value) {
        if (isBlank(value)) {
            return 0d;
        }
        return validate(value);
    }

    private Double validate(String value) {
        if (isNotPositiveNumber(value)) {
            throw new IllegalArgumentException();
        }
        return Double.parseDouble(value);
    }

    private boolean isNotPositiveNumber(String value) {
        return !value.matches("\\d*\\.?\\d+");
    }

    private boolean isBlank(String value) {
        return value.isBlank();
    }
}
