package calculator.domain.vo;

import calculator.domain.vo.exception.NegativeException;
import calculator.domain.vo.exception.NullEmptyException;

import java.util.List;

public record CalculationValues(List<Integer> numbers) {

    public CalculationValues(final List<Integer> numbers) {
        this.numbers = numbers;
        validateCalculation(numbers);
    }

    private void validateCalculation(List<Integer> beforeValidateCalculation) {
        if (beforeValidateCalculation.isEmpty()) {
            throw new NullEmptyException();
        }

        if (beforeValidateCalculation.stream()
                .anyMatch(n -> n < 0)) {
            throw new NegativeException();
        }
    }

}
