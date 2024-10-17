package calculator;

public class CustomChecker {
    private static final char[] CUSTOM_DELIMITER_PATTERN = {'/', '/', ' ', '\\', 'n'};

    public static boolean check(String input) {
        if (input.length() < 5) {
            return false;
        }

        for (int i = 0; i < CUSTOM_DELIMITER_PATTERN.length; i++) {
            if (i == 2) {
                continue;
            }
            char ch = input.charAt(i);
            if (ch != CUSTOM_DELIMITER_PATTERN[i]) {
                return false;
            }
        }
        return true;
    }
}
