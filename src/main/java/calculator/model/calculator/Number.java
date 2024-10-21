package calculator.model.calculator;

public class Number {
    private Long value;

    public Number(Long value) throws IllegalArgumentException {
        validate(value);
        this.value = value;
    }

    private void validate(Long value) {
        if (value < 0) {
            throw new IllegalArgumentException("잘못된 입력값 - 양수로 입력");
        }
    }

    public Number add(Number other) {
        return new Number(this.value + other.value);
    }

    public Long getValue() {
        return value;
    }
}
