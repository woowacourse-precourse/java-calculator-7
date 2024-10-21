package calculator.model.calculator;

// 식
public class Expression {
    private String value;

    public Expression(String value) throws IllegalArgumentException {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        if (value == null) {
            throw new IllegalArgumentException("입력 부탁드립니다.");
        }
    }

    public String getValue() {
        return value;
    }
}
