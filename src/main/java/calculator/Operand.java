package calculator;

public class Operand {

    private static final String ERROR_MESSAGE = "자연수를 입력하여야 합니다.";

    private final int value;

    public Operand(String value) {
        validate(value);
        this.value = Integer.parseInt(value);
    }

    public int getValue() {
        return value;
    }

    private void validate(String value) {
        validateNaturalNumber(value);
    }

    private void validateNaturalNumber(String value) {
        validateInteger(value);

        if (Integer.parseInt(value) <= 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private void validateInteger(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
