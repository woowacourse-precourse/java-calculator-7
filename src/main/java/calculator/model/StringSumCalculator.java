package calculator.model;

import java.util.List;

public class StringSumCalculator {
    public double calculate(String inputString) {
        StringParser stringParser = new StringParser(inputString);
        List<Double> numbers = stringParser.extractNumbers();

        return sum(numbers);
    }

    private double sum(List<Double> numbers) {
        return numbers.stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }
}
