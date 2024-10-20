package calculator.util;

public class CalculateSpecialSeparator {

    private static final Character BACK_SLASH = '\\';
    private static final String STRING_BACK_SLASH = "\\";
    private static final Character LEFT_PARENTHESIS = '(';
    private static final String STRING_LEFT_PARENTHESIS = "(";
    private static final Character RIGHT_PARENTHESIS = ')';
    private static final String STRING_RIGHT_PARENTHESIS = ")";
    private static final Character CARET = '^';
    private static final String STRING_CARET = "^";

    public static boolean checkContainBackSlash(String custom) {
        return custom.contains(STRING_BACK_SLASH);
    }

    public static boolean checkContainSpecial(String custom) {
        return custom.contains(STRING_LEFT_PARENTHESIS) || custom.contains(STRING_RIGHT_PARENTHESIS) || custom.contains(STRING_CARET);
    }

    public static String createNewCustom(String custom) {
        StringBuilder newCustom = new StringBuilder();
        for (int i = 0; i < custom.length(); i++) {
            Character customSlice = custom.charAt(i);
            if (checkIsCustomEqualSpecial(customSlice)) {
                newCustom.append(STRING_BACK_SLASH);
            }
            newCustom.append(customSlice);
            if (checkIsCustomEqualBackSlash(customSlice)) {
                newCustom.append(CalculateSpecialSeparator.STRING_BACK_SLASH);
            }
        }
        return newCustom.toString();
    }

    public static boolean checkIsCustomEqualBackSlash(Character custom) {
        return custom == BACK_SLASH;
    }

    public static boolean checkIsCustomEqualSpecial(Character custom) {
        return custom == LEFT_PARENTHESIS || custom == RIGHT_PARENTHESIS || custom == CARET;
    }
}
