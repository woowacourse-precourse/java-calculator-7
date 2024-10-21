package calculator.domain;

import java.util.List;

public class StringAddCalculator {
    private final Splitter splitter;
    private final NumberParser numberParser;

    public StringAddCalculator(Splitter splitter, NumberParser numberParser) {
        this.splitter = splitter;
        this.numberParser = numberParser;
    }

    public int calculate(String input) {
        List<String> stringNumbers = splitter.splitInputByDelimiter(input);
        List<Integer> numbers = numberParser.parseToIntegers(stringNumbers);

        return sum(numbers);
    }

    private int sum(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
