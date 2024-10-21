package calculator.util;

public class CalculateSpecialSeparator {

    private static final Character BACK_SLASH = '\\';
    private static final String STRING_BACK_SLASH = "\\";
    private static final String SPECIAL = "()^&*+|{.$[";
    private static final String SPECIAL_REGEX = "[()^&*+|{.$]";
    private static final String LEFT_BRACKET = "[";

    public static boolean checkContainBackSlash(String custom) {
        return custom.contains(STRING_BACK_SLASH);
    }

    public static boolean checkContainSpecial(String custom) {
        return custom.matches(SPECIAL_REGEX) || checkContainLeftBracket(custom);
    }

    public static boolean checkContainLeftBracket(String custom) {
        return custom.contains(LEFT_BRACKET);
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
        return SPECIAL.contains(String.valueOf(custom));
    }
}
