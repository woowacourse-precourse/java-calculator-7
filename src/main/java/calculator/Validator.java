package calculator;

public class Validator {
    public boolean hasCustomSeparator(String input) {
        return input.startsWith("//") && input.contains("\n");
    }

    public boolean isStartWithDigit(String input) {
        return Character.isDigit(input.charAt(0));
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
}
