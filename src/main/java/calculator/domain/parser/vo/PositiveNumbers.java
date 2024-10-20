package calculator.domain.parser.vo;

import java.util.List;
import java.util.stream.Collectors;

public class PositiveNumbers {
    private final List<PositiveNumber> numbers;

    public PositiveNumbers(List<Integer> numbers) {
        this.numbers = numbers.stream()
                .map(PositiveNumber::new)
                .toList();
    }


    public int sum() {
        return numbers.stream()
                .mapToInt(PositiveNumber::getValue)
                .sum();
    }

    public List<Integer> getValues() {
        return numbers.stream()
                .map(PositiveNumber::getValue)
                .collect(Collectors.toList());
    }

}
