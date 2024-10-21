package calculator;

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

    public static void check(final Operands operands) {
        for (String operand : operands.toList()) {
            if (!isNumeric(operand)) {
                throw new IllegalArgumentException("피연산자는 숫자로만 이루어져야 합니다: " + operand);
            }
        }
    }

    // TODO: 분리 필요
    private static boolean isNumeric(final String str) {
        return str.chars().allMatch(Character::isDigit);
    }

    public List<String> toList() {
        return List.copyOf(operands);
    }

}
