package calculator.Model;

import calculator.Constants.ErrorMessages;
import java.util.List;

public class Numbers {
    private final List<Number> numbers;

    public Numbers(List<Number> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public int getSum() {
        return numbers.stream()
                .mapToInt(Number::getNumber)
                .sum();
    }

    private void validateNumbers(List<Number> numbers) {
        isNumbersEmpty(numbers);
    }

    private void isNumbersEmpty(List<Number> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NUMBERS_EMPTY_MESSAGE.getErrorMessage());
        }
    }
}
