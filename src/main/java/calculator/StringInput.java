package calculator;

public class StringInput {
    private static final String BLINK_INPUT_ERROR = "입력된 값이 없습니다.";
    private final String input;

    public StringInput(String input) {
        validateString(input);
        this.input = input;
    }

    private void validateString(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException(BLINK_INPUT_ERROR);
        }
    }

    private boolean isBlank(String input) {
        return (input == null || input.trim().isEmpty());
    }
}
