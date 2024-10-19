package calculator.validators;

import calculator.domain.Calculator;
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

    public static void validateDelimiterSurroundings(Calculator calculator, String s) {
        String[] split = s.split("[" + calculator.getDelimitersAsString() + "]");

        for (int i = 0; i < split.length; i++) {
            String part = split[i];

            if (part.isEmpty()) {
                throw new IllegalArgumentException();
            }
            if (!isNumber(part)) {
                throw new IllegalArgumentException();
            }
        }


    }

    private static boolean isNumber(String part) {
        try {
            Integer.parseInt(part);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
