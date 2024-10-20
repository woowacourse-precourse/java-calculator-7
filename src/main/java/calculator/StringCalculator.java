package calculator;

import java.util.List;

public class StringCalculator {

    public int add(List<Operand> operands) {
        return operands.stream()
                .mapToInt(Operand::getValue)
                .sum();
    }
}
