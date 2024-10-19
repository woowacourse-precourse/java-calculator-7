package calculator;

import java.util.*;
import java.util.regex.Pattern;

public class Expression {

    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\\\n";
    private static final Set<String> DEFALUT_DELIMITER_SET = Set.copyOf(Set.of(",", ":"));

    private final Set<String> delimiters;
    private final List<String> operands;

    private static int startIndex = 0;


    private Expression(Set<String> customDelimiters, Collection<String> operands) {
        validate(customDelimiters, operands);

        this.delimiters = new HashSet<>(DEFALUT_DELIMITER_SET);
        this.delimiters.addAll(customDelimiters);

        this.operands = new ArrayList<>(operands);
    }

    public static Expression of(Collection<String> operands) {
        return new Expression(Set.of(), operands);
    }

    public static Expression of(Set<String> customDelimiters, Collection<String> operands) {
        return new Expression(customDelimiters, operands);
    }

    public static Expression parse(String expr) {
        final Set<String> parsedDelimiters = new HashSet<>(parseCustomDelimiters(expr));
        final List<String> parsedOperands = parseOperands(expr, parsedDelimiters);

        return Expression.of(parsedDelimiters, parsedOperands);
    }

    private static Set<String> parseCustomDelimiters(String expr) {
        final String str = expr.substring(startIndex);
        final Set<String> delimiters = new HashSet<>();

        while (str.startsWith(CUSTOM_DELIMITER_PREFIX, startIndex)) {

            startIndex += CUSTOM_DELIMITER_PREFIX.length();

            int endIndex = str.indexOf(CUSTOM_DELIMITER_SUFFIX, startIndex);
            final String candidate = str.substring(startIndex, endIndex);
            if (candidate.contains(CUSTOM_DELIMITER_PREFIX)) {
                throw new IllegalArgumentException("커스텀 구분자에 " + CUSTOM_DELIMITER_PREFIX + "는 포함할 수 없습니다.");
            }
            //TODO: CUSTOM_DELIMITER_SUFFIX도 있는지 검증
            delimiters.add(candidate);

            startIndex = endIndex + CUSTOM_DELIMITER_SUFFIX.length();
        }

        return delimiters;
    }

    private static List<String> parseOperands(String expr, Set<String> delimiters) {
        final String str = expr.substring(startIndex);

        return new ArrayList<>(Arrays.stream(str.split(buildDelimiterRegex(delimiters)))
                .map(String::trim)
                .toList());
    }

    private static String buildDelimiterRegex(Set<String> delimiters) {
        final StringBuilder sb = new StringBuilder();
        delimiters.addAll(DEFALUT_DELIMITER_SET);

        for (String delimiter : delimiters) {
            sb.append(Pattern.quote(delimiter));
            sb.append("|");
        }
        sb.delete(sb.length() - 1, sb.length());

        return sb.toString();
    }

    private static void validate(Set<String> delimiters, Collection<String> operands) {
        for (String delimiter : delimiters) {
            if (isNumeric(delimiter)) {
                throw new IllegalArgumentException("커스텀 구분자는 숫자로만 이루어져서는 안됩니다: " + delimiter);
            }
        }

        for (String operand : operands) {
            if (!isNumeric(operand)) {
                throw new IllegalArgumentException("올바르지 않은 피연산자입니다: " + operand);
            }
        }
    }

    private static boolean isNumeric(String str) {
        return str.chars().allMatch(Character::isDigit);
    }

    public Set<String> getDelimiters() {
        return new HashSet<>(delimiters);
    }

    public List<String> getOperands() {
        return new ArrayList<>(operands);
    }
}
