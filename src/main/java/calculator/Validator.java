package calculator;

public class Validator {

    static void validateString(String str, String separators) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!isSeparator(c, separators) && !Character.isDigit(c)) {
                throw new IllegalArgumentException("문자열 에러");
            }
        }
    }

    static boolean isSeparator(char c, String separators) {
        for (int i = 0; i < separators.length(); i++) {
            if (c == separators.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    static boolean validateCustomSeparator(String input) {
        if (input.indexOf("\\n") != 3) {
            return false;
        } else {
            return !isSeparatorNumeric(input.charAt(2));
        }
    }

    static boolean isSeparatorNumeric(char separator) {
        return Character.isDigit(separator);
    }

}
