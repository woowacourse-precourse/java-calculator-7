package calculator.validate;

import calculator.exception.InvalidFormatException;
import java.util.List;
import java.util.regex.Pattern;

public class CalculatorValidator {

    private static final List<String> REGEX_LIST = List.of(
            "^//([^0-9])\\\\n([0-9]+(\\1[0-9]+)*)*$",    // Custom delimiter expression
            "^([0-9]+([,:][0-9]+)*)*$"         // Default expression with multiple digits
    );

    public static void validateExpression(String expression) {
        if (!isValidExpression(expression) || !isValidExpressionWithRegex(expression)) {
            throw new InvalidFormatException();
        }
    }

    public static boolean isCustomDelimiterExpression(String expression) {
        return expression.startsWith("//") && expression.contains("\\n");
    }

    public static boolean isValidExpressionWithRegex(String expression) {
        return REGEX_LIST.stream().anyMatch(regex -> Pattern.matches(regex, expression));
    }

    private static boolean isValidExpression(String expression) {
        return expression != null && !expression.trim().isEmpty();
    }

}

