package calculator.operands;

import java.util.regex.Pattern;

public class PositiveIntegerOperands extends Operands<Long> {

    public boolean validate(String operand) {
        String regEx = "\\d*";
        return Pattern.matches(regEx, operand);
    }

    public void addOperand(String operand) {
        this.data.add(Long.parseLong(operand));
    }
}
