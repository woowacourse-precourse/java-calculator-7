package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberManager {
    private final SeparatorManager separatorManager;

    public NumberManager(SeparatorManager separatorManager) {
        this.separatorManager = separatorManager;
    }

    public void calculate(String numberString) {
        List<Number> numbers = splitAndConvertToNumbers(numberString);
        ResultPrinter.print(sum(numbers));
    }

    private List<Number> splitAndConvertToNumbers(String numberString) {
        return Arrays.stream(separatorManager.split(numberString))
                .map(Number::new)
                .collect(Collectors.toList());
    }

    private int sum(List<Number> numbers) {
        return numbers.stream().mapToInt(Number::getValue).sum();
    }
}