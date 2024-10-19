package calculator.service;

import calculator.model.PositiveNumbers;

import java.util.List;

public class CalculateService {
    public int sum(List<Integer> numbers) {
        PositiveNumbers positiveNumbers = new PositiveNumbers(numbers);
        return positiveNumbers.sum();
    }
}
