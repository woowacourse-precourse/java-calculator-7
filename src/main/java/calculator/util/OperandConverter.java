package calculator.util;

import calculator.model.Operand;

import java.util.List;

public class OperandConverter {

    public static List<Operand> convertToOperands (List<String> input) {
        return input.stream()
                .map(Integer::parseInt)
                .map(Operand::new)
                .toList();
    }
}
