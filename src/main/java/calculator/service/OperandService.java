package calculator.service;

import java.util.ArrayList;
import java.util.List;

public class OperandService {

    public List<Integer> operands;

    public OperandService() {
        this.operands = new ArrayList<>();
    }

    public void indexingOperands(String[] expression) {
        int idx = 0;
        while (idx < expression.length) {
            if (Character.isDigit(expression[idx].charAt(0))) {
                idx = saveOperand(expression, idx);
            }
            idx++;
        }
    }

    public int saveOperand(String[] expression, int idx) {
        int result = 0;
        while (idx < expression.length && Character.isDigit(expression[idx].charAt(0))) {
            result = result * 10 + Integer.parseInt(expression[idx++]);
        }
        this.operands.add(result);
        return idx;
    }
}
