package calculator.domain;

import java.util.List;

public class SumCalculator {
    private int result = 0;

    public int getResult(List<Integer> inputNumber) {
        calculateResult(inputNumber);
        return this.result;
    }

    private void calculateResult(List<Integer> inputNumber) {
        for (int num : inputNumber) {
            this.result += num;
        }
    }
}
