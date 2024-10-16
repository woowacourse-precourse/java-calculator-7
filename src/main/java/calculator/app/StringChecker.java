package calculator.app;

import java.util.ArrayList;
import java.util.List;

public class StringChecker {

    private static String LEFT_SEPARATOR = "//";
    private static String RIGHT_SEPARATOR = "\\n";
    private static List<Character> BASIC_SEPARATOR = List.of(',', ':');

    public List<Character> checkCustomSeparator(String expression) {
        if (expression.length() >= 5 && expression.substring(0, 2).equals(LEFT_SEPARATOR) && expression.substring(3, 5)
                .equals(RIGHT_SEPARATOR)) {
            List<Character> customSeparator = new ArrayList<>(BASIC_SEPARATOR);
            customSeparator.add(expression.charAt(2));
            return customSeparator;
        }
        return BASIC_SEPARATOR;
    }
}
