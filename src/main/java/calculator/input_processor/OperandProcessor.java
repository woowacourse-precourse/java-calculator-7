package calculator.input_processor;

import java.util.List;

public class OperandProcessor {

    public int add(List<Integer> operands) {
        int sum = 0;
        for (int operand : operands) {
            sum += operand;
        }
        return sum;
    }
}
