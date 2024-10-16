package calculator.validation;

public class inputValidator {
    private static final String ERROR_PREFIX = "[ERROR]";
    private static final String EMPTY_INPUT = "입력값이 없습니다.";

    private String input;

    public inputValidator(String input) {
        this.input = input;
    }

    public void inputValidate() {
        try {
            isEmpty();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    private void isEmpty() {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_PREFIX + EMPTY_INPUT);
        }
    }

}
