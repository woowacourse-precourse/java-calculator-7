package calculator.service;

import java.util.Arrays;

public class CalculatorService {

    public int calculatorNumbers(int[] numbers) {
        return Arrays.stream(numbers)
                .sum();
    }
}