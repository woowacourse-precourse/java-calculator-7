package calculator;

public class CustomPartManager {

    static boolean validateCustomSeparator(String input) {
        if (input.indexOf("\\n") != 3) {
            throw new IllegalArgumentException("커스텀 구분자의 길이가 1이 아닙니다");
        }
        return !isSeparatorNumeric(input.charAt(2));
    }

    static boolean isSeparatorNumeric(char separator) {
        return Character.isDigit(separator);
    }

    static boolean validateCustomPart(String input) {
        if (hasCustomPart(input)) {
            if (!validateCustomSeparator(input)) {
                throw new IllegalArgumentException("커스텀 구분자가 숫자입니다");
            }
            return true;
        }
        return false;
    }

    static boolean hasCustomPart(String input) {
        if (input.startsWith("//")) {
            return input.contains("\\n");
        }
        return false;
    }
}
