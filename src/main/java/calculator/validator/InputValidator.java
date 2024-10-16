package calculator.validator;

public class InputValidator {

    private InputValidator() {
    }

    public static void validate(String input) {

    }

    public static void validateBlank(String input) {
        if (!input.isEmpty() && input.isBlank()) {
            throw new IllegalArgumentException("입력 문자열은 공백으로만 구성될 수 없습니다.");
        }
    }
}
