package calculator.service;

import calculator.domain.Calculator;

import java.util.Arrays;
import java.util.List;

public class CalculatorService {

    public int calculate(String input) {
        String delimiter = "[,:]";

        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");

            delimiter = input.substring(2, delimiterEndIndex);

            input = input.substring(delimiterEndIndex + 2);
        }

        String[] number = input.split(delimiter);
        List<Integer> num = Arrays.stream(number)
                .map(Integer::parseInt)
                .toList();

        validateNumber(num);

        Calculator calculator = new Calculator(num);
        return calculator.calculateSum();
    }

    private void validateNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException("음수");
            }
        }
    }

}
