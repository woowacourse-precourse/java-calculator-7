package calculator;

import java.util.Set;

public class CalculatorUtil {

    private static final String DEFAULT_SEPARATOR = "[: ,]";

    private static final Set<Character> META_CHARACTER_SET = Set.of(
            '\\', '^', '$', '.', '|', '?', '*', '+', '(', ')', '[', ']', '{', '}'
    );

    public static String getSeparatorRegex(String input) {
        if (input.startsWith("//")) {
            String[] tokens = input.split("\\\\n");
            String separator = tokens[0].substring(2);

            if (META_CHARACTER_SET.contains(separator.charAt(0))) {
                return String.format("\\%s", separator);
            }

            return separator;
        }
        else return DEFAULT_SEPARATOR;
    }

    public static String getExpression(String input) {
        if (input.startsWith("//")) {
            String[] tokens = input.split("\\\\n");
            if (tokens.length == 1)
                return "";

            return tokens[1];
        }

        return input;
    }
}
