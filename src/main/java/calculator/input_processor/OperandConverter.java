package calculator.input_processor;

import java.util.Arrays;
import java.util.List;

public class OperandConverter {

    public List<Integer> convertOperandToInt(String[] operands) {
        if (operands.length == 1 && operands[0].isEmpty()) {
            return List.of(0);
        }
        return Arrays.stream(operands)
                .filter(this::validPositiveNum)
                .map(Integer::parseInt)
                .toList();
    }

    private boolean validPositiveNum(String operand) {
        if (!operand.matches("\\d+")) {
            if (operand.matches("-\\d+")) {
                throw new IllegalArgumentException(operand + ": 음수는 입력할 수 없습니다.");
            }
            throw new IllegalArgumentException(operand + ": 양의 정수가 아닙니다.");
        }
        return true;
    }
}
