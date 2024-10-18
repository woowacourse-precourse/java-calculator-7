package calculator;

import java.util.List;

public class SumValues {
    private final List<SumValue> sumValues;
    private int totalSum = 0;

    public SumValues(List<SumValue> sumValues) {
        this.sumValues = sumValues;
    }

    public int sumAll() {
        sumValues.stream()
                .forEach(sumValue -> totalSum += sumValue.getValue());

        return totalSum;
    }
}
