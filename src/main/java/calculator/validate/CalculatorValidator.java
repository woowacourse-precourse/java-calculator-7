package calculator.validate;

import calculator.exception.InvalidFormatException;
import java.util.List;
import java.util.regex.Pattern;

public class CalculatorValidator {
    private static final List<Pattern> REGEX_PATTERNS = List.of(
            Pattern.compile("^//([^0-9])\\\\n([0-9]+(\\1[0-9]+)*)*$"),   // Custom delimiter expression
            Pattern.compile("^[0-9]+([,:][0-9]+)*$")                  // Default expression with multiple digits
    );

    public static void validateExpression(String expression) {
        if (!isNonEmptyExpression(expression) || !matchesAnyPattern(expression)) {
            throw new InvalidFormatException();
        }
    }

    public static boolean isCustomDelimiterExpression(String expression) {
        return expression.startsWith("//") && expression.contains("\\n");
    }

    private static boolean matchesAnyPattern(String expression) {
        return REGEX_PATTERNS.stream().anyMatch(pattern -> pattern.matcher(expression).matches());
    }

    private static boolean isNonEmptyExpression(String expression) {
        return expression != null && !expression.trim().isEmpty();
    }
}
