package calculator.service.impl;

import calculator.model.Operand;
import calculator.service.CalculatorService;

public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public int calculate(Operand operand) {
        int sum = 0;
        for (int num : operand.getNumbers()) {
            sum += num;
        }
        return sum;
    }
}