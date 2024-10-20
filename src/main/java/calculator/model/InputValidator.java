package calculator.model;

public class InputValidator {
    private static InputValidator instance;

    private InputValidator() {}

    public static InputValidator getInstance() {
        if (instance == null) {
            instance = new InputValidator();
        }
        return instance;
    }
    public void validate(String input) throws IllegalArgumentException {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("빈 문자열 또는 null은 허용되지 않습니다.");
        }
    }
}
