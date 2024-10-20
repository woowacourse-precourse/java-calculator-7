package calculator.model;

public class InputValidator {

    public static InputValidator getInstance() {
        return new InputValidator();
    }

    private InputValidator() {
    }

    public void validate(String input) {
        if (!(DefaultDelimiter.hasDefaultDelimiter(input) || CustomDelimiter.getInstance()
                .hasCustomDelimiter(input))) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}
