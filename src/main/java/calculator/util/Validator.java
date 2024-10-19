package calculator.util;

public class Validator {
    public boolean hasCustomSeparator(String input) {
        if (isEmpty(input)) {
            return false;
        }
        return input.startsWith("//") && input.contains("\\n");
    }

    public boolean isStartWithDigit(String input) {
        if (isEmpty(input)) {
            return false;
        }
        return Character.isDigit(input.charAt(0));
    }

    public boolean isEmpty(String input) {
        return input == null || input.isBlank();
    }

    public void validateSeparator(String separator) {
        if (separator.length() != 1) {
            throw new IllegalArgumentException("구분자의 길이는 1이어야 합니다.");
        }
        if (separator.equals(",") || separator.equals(":")) {
            throw new IllegalArgumentException("이미 구분자로 등록 되어 있습니다.");
        }
        if (separator.equals(".")) {
            throw new IllegalArgumentException(".은 구분자가 될 수 없습니다.");
        }
        if (isStartWithDigit(separator)) {
            throw new IllegalArgumentException("숫자는 구분자가 될 수 없습니다.");
        }
    }

    public void validateInput(String input) {
        if (isEmpty(input)) {
            return;
        }
        if (hasCustomSeparator(input)) {
            return;
        }
        if (isStartWithDigit(input) && (!input.contains("//") && !input.contains("\\n"))) {
            return;
        }
        throw new IllegalArgumentException("포멧에 맞게 입력해 주세요.(ex://@\\n1@2:3,4)");
    }
}