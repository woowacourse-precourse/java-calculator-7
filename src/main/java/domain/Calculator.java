package domain;

import java.util.List;

public class Calculator {
    private int calculationResult;
    private final Separator separator;

    public Calculator(Separator separator) {
        this.separator = separator;
    }

    public int addNumber(List<Integer> numberCollection) {
        int sum = 0;

        for (Integer number : numberCollection) {
            sum += number;
        }
        calculationResult = sum;
        return sum;
    }

    public int getCalculator() {
        return calculationResult;
    }
}
