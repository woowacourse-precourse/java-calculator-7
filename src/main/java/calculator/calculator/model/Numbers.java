package calculator.calculator.model;

import java.util.List;

public record Numbers(List<PositiveNumber> numbers) {
    public Numbers(List<PositiveNumber> numbers) {
        this.numbers = List.copyOf(numbers);
    }
}
