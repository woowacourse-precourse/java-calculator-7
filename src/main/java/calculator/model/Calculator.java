package calculator.model;

import java.util.List;

public class Calculator {

    private final StringParser stringParser = new StringParser();

    public int sumNumbersFromString(String input) {
        List<Integer> numbers = stringParser.extractNumbers(input);

        return sumNumbers(numbers);
    }

    public int sumNumbers(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }

        return sum;
    }
}
