package calculator.domain.vo;

import java.util.List;

public class CalculationValues {

    private final List<Integer> numbers;

    public CalculationValues(final List<Integer> numbers) {
        this.numbers = numbers;
        validateCalculation(numbers);
    }

    private void validateCalculation(List<Integer> beforeValidateCalculation) {
        if (beforeValidateCalculation.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (beforeValidateCalculation.stream().anyMatch(n -> n < 0)) {
            throw new IllegalArgumentException();
        }
    }

}
