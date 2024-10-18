package calculator;

public class CustomPartManager {

    static boolean validateCustomSeparator(String input) {
        if (input.indexOf("\\n") != 3) {
            return false;
        }
        return !isSeparatorNumeric(input.charAt(2));
    }

    static boolean isSeparatorNumeric(char separator) {
        return Character.isDigit(separator);
    }
}
