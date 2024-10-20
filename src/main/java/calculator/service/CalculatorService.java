package calculator.service;

import calculator.util.StringSeperator;
import calculator.util.NumberSeperator;

import java.util.List;

public class CalculatorService {
    public int calculate(String input) {
        String expression = StringSeperator.parseCustomSeperator(input);
        List<Integer> numbers = NumberSeperator.parseNumbersFromDelimitedString(StringSeperator.getSeperator(), expression);

        return sum(numbers);
    }
    public int sum(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
