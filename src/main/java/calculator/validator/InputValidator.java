package calculator.validator;

public class InputValidator {
    public void validate(String input) {
        if (input.startsWith("//")) {
            validateCustomSeparator(input);
        }
    }

    private void validateCustomSeparator(String input) {
        int newLineIndex = input.indexOf("\\n");
        if (newLineIndex == -1 || newLineIndex <= 2) {
            throw new IllegalArgumentException("올바른 형식의 커스텀 구분자를 입력해 주세요.");
        }
        String customSeparator = input.substring(2, newLineIndex);
        if (customSeparator.isEmpty()) {
            throw new IllegalArgumentException("올바른 형식의 커스텀 구분자를 입력해 주세요.");
        }
    }
}