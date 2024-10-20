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

        List<String> separators = separator.getSeparatorCollection();

        for (Integer number : numberCollection) {
            sum += Integer.parseInt(String.valueOf(number));
        }
        calculationResult = sum;
        return sum;
    }

    public int getCalculator() {
        return calculationResult;
    }
}
