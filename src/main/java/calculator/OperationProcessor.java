package calculator;

import java.util.ArrayList;
import java.util.List;

public class OperationProcessor {
    List<Integer> operands; // 피연산자(숫자)

    public OperationProcessor() {
        operands = new ArrayList<>();
    }

    /**
     * 덧셈 연산 수행
     */
    public int calculate(List<Integer> operands) {
        int result = 0;
        for (int operand : operands) {
            result += operand;
        }
        return result;
    }
}
