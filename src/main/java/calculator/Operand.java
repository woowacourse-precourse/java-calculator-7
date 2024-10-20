package calculator;

public class Operand {

    private static final String ERROR_MESSAGE = "정수를 입력하여야 합니다.";

    private final int value;

    public Operand(String value) {
        validate(value);
        this.value = Integer.parseInt(value);
    }

    public int getValue() {
        return value;
    }

    private void validate(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
