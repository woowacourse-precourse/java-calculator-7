package calculator.validators;

import java.util.List;

public class Validators {

    public static boolean validateDelimiterDeclaration(String s) {
        if (s.startsWith("//")) {
            if (!s.contains("\\n")) {
                throw new IllegalArgumentException();
            }
            return true;
        }
        return false;
    }

    public static void validateAllowedCharacters(List<Character> cha, String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c) && !cha.contains(c)) {
                throw new IllegalArgumentException();
            }
        }
    }
}
