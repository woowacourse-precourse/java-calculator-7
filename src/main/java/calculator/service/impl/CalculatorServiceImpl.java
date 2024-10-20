package calculator.service.impl;

import calculator.service.CalculatorService;

public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public int calculate(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}