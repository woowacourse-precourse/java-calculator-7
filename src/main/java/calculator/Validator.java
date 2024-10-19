package calculator;

public class Validator {
    public static boolean isValidCustomDelimiter(String input) {
        if (input.substring(0, 2).equals("//") == false ||
                input.substring(3, 5).equals("\\n") == false)
            return false;
        return true;

    }

    public static boolean isValidDefaultDelimiterString(String input) {
        for (char c : input.toCharArray()) {
            if (c != '-' && c != '+' &&
                c != ',' && c != ':' &&
                Character.isDigit(c) == false)
                return false;
        }
        return true;
    }

    public static boolean isValidCustomDelimiterString(String input) {
        return true;
    }
}