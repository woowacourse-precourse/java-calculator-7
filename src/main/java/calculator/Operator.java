package calculator;

import static calculator.Constants.*;

import java.util.List;

public class Operator {
    public int add(List<Integer> operands) {
        int result = 0;
        for (Integer operand : operands) {
            if ((long) result + operand > MAX_ADD_VALUE) {
                throw new IllegalArgumentException(EXCEEDS_LIMIT_MESSAGE);
            }
            result += operand;
        }
        return result;
    }
}
