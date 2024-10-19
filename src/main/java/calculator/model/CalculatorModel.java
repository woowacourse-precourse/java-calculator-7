package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class CalculatorModel {
    private List<Integer> operand = new ArrayList<>();

    public CalculatorModel(List<Integer> operands) {
        this.operand = operands;
    }

    public int calculateSum() {
        int sum = 0;

        for (int i = 0; i < operand.size(); i++) {
            sum += operand.get(i);
        }
        return sum;
    }
}
