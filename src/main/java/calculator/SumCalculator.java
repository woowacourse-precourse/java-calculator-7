package calculator;

import java.util.List;

public class SumCalculator {
    private List<Integer> numbers;

    public SumCalculator() {
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Integer sumNumbers() {
        int sumResult = 0;
        for (Integer number : numbers) {
            sumResult += number;
        }

        return sumResult;
    }
}
