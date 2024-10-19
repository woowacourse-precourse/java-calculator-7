package calculator;

import java.util.List;

public class StringSumCalculator {
    public void run() {
        String inputString = InputHandler.inputString();

        StringParser stringParser = new StringParser(inputString);
        List<Double> numbers = stringParser.extractNumbers();
        double result = sum(numbers);

        OutputHandler.printResult(result);
    }

    private double sum(List<Double> numbers) {
        return numbers.stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }
}
