package calculator.Model;

import calculator.Constants.ErrorMessages;
import java.util.ArrayList;


public class Numbers {
    private final ArrayList<Number> numbers;

    public Numbers(ArrayList<Number> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(ArrayList<Number> numbers) {
        isNumbersEmpty(numbers);
    }

    private void isNumbersEmpty(ArrayList<Number> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NUMBERS_EMPTY_MESSAGE.getErrorMessage());
        }
    }
}
