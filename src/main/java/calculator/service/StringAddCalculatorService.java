package calculator.service;

import calculator.domain.SplitNumbers;

public class StringAddCalculatorService {
    public int getResult(String inputValue) {
        SplitNumbers splitNumbers = SplitNumbers.from(inputValue);
        return sumIntegers(splitNumbers);
    }

    private int sumIntegers(SplitNumbers splitNumbers) {
        return splitNumbers.getNumbers().stream().reduce(0, Integer::sum);
    }
}