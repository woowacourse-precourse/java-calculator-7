package calculator;

import java.util.*;
import java.util.regex.Pattern;

public class Expression {

    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private static final Set<String> DEFALUT_DELIMITER_SET = Set.copyOf(Set.of(",", ":"));

    private final Set<String> delimiters;
    private final List<String> operands;


    private Expression(final Set<String> customDelimiters, final Collection<String> operands) {
        checkDelimitersConstraints(customDelimiters);
        checkOperandsConstraints(operands);

        this.delimiters = new HashSet<>(DEFALUT_DELIMITER_SET);
        this.delimiters.addAll(customDelimiters);

        this.operands = new ArrayList<>(operands);
    }

    public static Expression of(final Collection<String> operands) {
        return new Expression(Set.of(), operands);
    }

    public static Expression of(final Set<String> customDelimiters, final Collection<String> operands) {
        return new Expression(customDelimiters, operands);
    }

    public static Expression parse(final String expr) {
        final Set<String> parsedDelimiters = new HashSet<>(parseCustomDelimiters(expr));
        final List<String> parsedOperands = parseOperands(expr, parsedDelimiters);

        return Expression.of(parsedDelimiters, parsedOperands);
    }

    private static Set<String> parseCustomDelimiters(final String expr) {
        final Set<String> delimiters = new HashSet<>();
        int startIndex = 0;

        while (expr.startsWith(CUSTOM_DELIMITER_PREFIX, startIndex)) {

            startIndex += CUSTOM_DELIMITER_PREFIX.length();

            int endIndex = expr.indexOf(CUSTOM_DELIMITER_SUFFIX, startIndex);
            final String candidate = expr.substring(startIndex, endIndex);

            delimiters.add(candidate);

            startIndex = endIndex + CUSTOM_DELIMITER_SUFFIX.length();
        }

        return delimiters;
    }

    private static List<String> parseOperands(final String expr, final Set<String> delimiters) {
        int startIndex = 0;
        for (String delimiter : delimiters) {
            startIndex += delimiter.length() + CUSTOM_DELIMITER_PREFIX.length() + CUSTOM_DELIMITER_SUFFIX.length();
        }
        final String str = expr.substring(startIndex);

        return new ArrayList<>(Arrays.stream(str.split(buildDelimiterRegex(delimiters)))
                .map(String::trim)
                .toList());
    }

    private static String buildDelimiterRegex(final Set<String> delimiters) {
        final StringBuilder sb = new StringBuilder();
        delimiters.addAll(DEFALUT_DELIMITER_SET);

        for (String delimiter : delimiters) {
            sb.append(Pattern.quote(delimiter));
            sb.append("|");
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    public static void checkDelimitersConstraints(final Set<String> delimiters) {
        for (String delimiter : delimiters) {
            if (isNumeric(delimiter)) {
                throw new IllegalArgumentException("커스텀 구분자는 숫자로만 이루어져서는 안됩니다: " + delimiter);
            }

            if (delimiter.isBlank() || delimiter.contains(CUSTOM_DELIMITER_PREFIX)
                    || delimiter.contains(CUSTOM_DELIMITER_SUFFIX)) {
                throw new IllegalArgumentException("올바르지 않은 커스텀 구분자입니다: " + delimiter);
            }
        }
    }

    public static void checkOperandsConstraints(final Collection<String> operands) {
        for (String operand : operands) {
            if (!isNumeric(operand)) {
                throw new IllegalArgumentException("피연산자는 숫자로만 이루어져야 합니다: " + operand);
            }
        }
    }

    private static boolean isNumeric(final String str) {
        return str.chars().allMatch(Character::isDigit);
    }

    public Set<String> getDelimiters() {
        return new HashSet<>(delimiters);
    }

    public List<String> getOperands() {
        return new ArrayList<>(operands);
    }
}
