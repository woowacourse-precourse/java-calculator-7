package calculator.operands;

import java.util.regex.Pattern;

public class PositiveIntegerOperands extends Operands<Long> {

    public Class<Long> getType() {
        return Long.class;
    }

    public boolean validate(String operand) {
        String regEx = "\\d*";
        return Pattern.matches(regEx, operand);
    }

    public void addOperand(String operand) {
        try {
            this.data.add(Long.parseLong(operand));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력한 숫자가 허용된 범위를 벗어났습니다.");
        }
    }
}
