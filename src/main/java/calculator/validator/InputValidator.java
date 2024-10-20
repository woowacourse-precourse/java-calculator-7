package calculator.validator;

public class InputValidator {
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    public void validate(String input) {
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            validateCustomSeparator(input);
        }
    }

    private void validateCustomSeparator(String input) {
        int newLineIndex = input.indexOf(CUSTOM_DELIMITER_SUFFIX);
        if (newLineIndex == -1 || newLineIndex <= CUSTOM_DELIMITER_PREFIX.length()) {
            throw new IllegalArgumentException("올바른 형식의 커스텀 구분자를 입력해 주세요.");
        }
        String customSeparator = input.substring(CUSTOM_DELIMITER_PREFIX.length(), newLineIndex);
        if (customSeparator.isEmpty()) {
            throw new IllegalArgumentException("올바른 형식의 커스텀 구분자를 입력해 주세요.");
        }
        // 구분자 뒤에 숫자가 있는지 확인
        String restOfInput = input.substring(newLineIndex + CUSTOM_DELIMITER_SUFFIX.length());
        if (restOfInput.isEmpty()) {
            throw new IllegalArgumentException("구분자 뒤에 숫자를 입력해 주세요.");
        }
    }
}