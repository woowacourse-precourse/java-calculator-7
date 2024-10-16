package calculator;

import java.util.*;
import java.util.regex.Pattern;

public class Adder {

    private final Set<String> delimiters;
    private final List<String> operands = new ArrayList<>();
    private final String expr;


    public Adder(String expr) {
        this(expr, Set.of());
    }

    public Adder(String expr, Collection<String> delimiters) {
        this.expr = expr;
        this.delimiters = new HashSet<>(Set.of(",", ":"));
        this.delimiters.addAll(delimiters);
    }

    public int run() {
        extractOperands();
        validate();

        return getTotalSum();
    }

    private void extractOperands() {
        operands.addAll(
                Arrays.stream(expr.split(buildDelimiterRegex()))
                        .map(String::trim)
                        .toList());
    }

    private void validate() {
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

    private int getTotalSum() {
        int sum = 0;

        for (String operand : operands) {
            sum += Integer.parseInt(operand);
        }
        return sum;
    }


    private String buildDelimiterRegex() {
        final StringBuilder sb = new StringBuilder();
        for (String delimiter : delimiters) {
            sb.append(Pattern.quote(delimiter));
            sb.append("|");
        }
        sb.delete(sb.length() - 1, sb.length());

        return sb.toString();
    }

    private boolean isNumeric(String str) {
        return str.chars().allMatch(Character::isDigit);
    }
}
