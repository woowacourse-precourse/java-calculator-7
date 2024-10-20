package calculator.validator;

import java.util.List;

public class InputValidatorUtils {

    public static boolean hasNegativeValue(List<Integer> list) {
        for (Integer i : list) {
            if (i < 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean customDelimiterContains(String input) {
        return input.startsWith("//");
    }

    public static boolean isSpecialDelimiter(String string) {
        if (string.equals("\"") || string.equals("\'") || string.equals("\\") || string.equals("(") ||
                string.equals(")") || string.equals("[") || string.equals("]") || string.equals("}") ||
                string.equals("{") || string.equals("?") || string.equals("*") || string.equals("|")) {
            return true;
        }

        return false;
    }
}
