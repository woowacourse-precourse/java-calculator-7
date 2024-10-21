package calculator.domain;

import static calculator.util.ExpressionUtils.isNumeric;

import java.util.List;

public class Operands {

    private final List<String> operands;

    private Operands() {
        this(List.of());
    }

    private Operands(final List<String> operands) {
        this.operands = operands;
    }

    public static Operands of() {
        return new Operands();
    }

    public static Operands of(final List<String> operands) {
        return new Operands(operands);
    }

    public static Operands of(final String... operands) {
        return new Operands(List.of(operands));
    }

    public static void check(final Operands operands) {
        for (String operand : operands.toList()) {
            if (!isNumeric(operand)) {
                throw new IllegalArgumentException("피연산자는 숫자로만 이루어져야 합니다: " + operand);
            }
        }
    }

    public List<String> toList() {
        return List.copyOf(operands);
    }

}
