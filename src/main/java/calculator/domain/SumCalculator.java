package calculator.domain;

import java.util.ArrayList;

public class SumCalculator {
    private int result = 0;

    public int getResult(ArrayList<Integer> inputNumber) {
        calculateResult(inputNumber);
        return this.result;
    }

    private void calculateResult(ArrayList<Integer> inputNumber) {
        for (int num : inputNumber) {
            this.result += num;
        }
    }
}
