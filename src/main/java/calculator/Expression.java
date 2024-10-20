package calculator;

import java.util.*;
import java.util.regex.Pattern;

public class Expression {

    public static final Set<String> DEFAULT_DELIMITERS = Collections.unmodifiableSet(Set.of(",", ":"));
    public static final String CUSTOM_DELIMITER_PREFIX = "//";
    public static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    private final Delimiters delimiters;
    private final List<String> operands;

    private Expression(final Delimiters customDelimiters, final Collection<String> operands) {
        Delimiters.check(customDelimiters);
        checkOperandsConstraints(operands);

        delimiters = Delimiters.of(addDefaultDelimiters(DEFAULT_DELIMITERS));
        this.operands = new ArrayList<>(operands);
    }

    public static Expression of(final Collection<String> operands) {
        return new Expression(Delimiters.of(), operands);
    }

    public static Expression of(final Delimiters customDelimiters, final Collection<String> operands) {
        return new Expression(customDelimiters, operands);
    }

    public static Expression parse(final String expr) {
        final Delimiters delimiters = parseCustomDelimiters(expr);
        final List<String> parsedOperands = parseOperands(expr, delimiters);

        return Expression.of(delimiters, parsedOperands);
    }

    private static Delimiters parseCustomDelimiters(final String expr) {
        final Set<String> delimiters = new HashSet<>();
        int startIndex = 0;

        while (expr.startsWith(CUSTOM_DELIMITER_PREFIX, startIndex)) {

            startIndex += CUSTOM_DELIMITER_PREFIX.length();

            int endIndex = expr.indexOf(CUSTOM_DELIMITER_SUFFIX, startIndex);
            final String candidate = expr.substring(startIndex, endIndex);

            delimiters.add(candidate);

            startIndex = endIndex + CUSTOM_DELIMITER_SUFFIX.length();
        }

        return Delimiters.of(delimiters);
    }

    private static List<String> parseOperands(final String expr, final Delimiters delimiters) {
        int startIndex = 0;
        for (String delimiter : delimiters.toSet()) {
            startIndex += delimiter.length() + CUSTOM_DELIMITER_PREFIX.length() + CUSTOM_DELIMITER_SUFFIX.length();
        }
        final String str = expr.substring(startIndex);

        return new ArrayList<>(Arrays.stream(str.split(buildDelimiterRegex(delimiters)))
                .map(String::trim)
                .toList());
    }

    private static String buildDelimiterRegex(final Delimiters delimiters) {
        final StringBuilder sb = new StringBuilder();

        final Set<String> delimiterSet = addDefaultDelimiters(delimiters.toSet());

        for (String delimiter : delimiterSet) {
            sb.append(Pattern.quote(delimiter));
            sb.append("|");
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    public static void checkOperandsConstraints(final Collection<String> operands) {
        for (String operand : operands) {
            if (!isNumeric(operand)) {
                throw new IllegalArgumentException("피연산자는 숫자로만 이루어져야 합니다: " + operand);
            }
        }
    }

    private static Set<String> addDefaultDelimiters(final Set<String> delimiters) {
        Set<String> delimiterSet = new HashSet<>(DEFAULT_DELIMITERS);
        delimiterSet.addAll(delimiters);

        return delimiterSet;
    }

    private static boolean isNumeric(final String str) {
        return str.chars().allMatch(Character::isDigit);
    }

    public Delimiters getDelimiters() {
        return delimiters;
    }

    public List<String> getOperands() {
        return new ArrayList<>(operands);
    }
}
