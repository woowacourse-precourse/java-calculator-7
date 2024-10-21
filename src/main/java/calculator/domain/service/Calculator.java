package calculator.domain.service;

import calculator.domain.model.value.PositiveNumber;

import java.util.List;

public class Calculator {

    public Long getSum(List<PositiveNumber> numbers) {
        return numbers.stream()
                .mapToLong(PositiveNumber::value)
                .sum();
    }
}
