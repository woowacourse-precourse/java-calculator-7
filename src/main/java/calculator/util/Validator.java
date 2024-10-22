package calculator.util;

public class Validator {
    public boolean hasCustomSeparator(String input) {
        if (isEmpty(input)) {
            return false;
        }
        return input.startsWith(Constants.CUSTOM_PREFIX) && input.contains(Constants.CUSTOM_SUFFIX);
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
        if (separator.length() != Constants.SEPARATOR_LENGTH) {
            throw new IllegalArgumentException("구분자의 길이는 1이어야 합니다.");
        }
        if (separator.equals(Constants.DECIMAL_POINT)) {
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
        if (isStartWithDigit(input)) {
            if ((!input.contains(Constants.CUSTOM_PREFIX) && !input.contains(Constants.CUSTOM_SUFFIX))) {
                return;
            }
        }
        throw new IllegalArgumentException("포멧에 맞게 입력해 주세요.(ex://@\\n1@2:3,4)");
    }
}