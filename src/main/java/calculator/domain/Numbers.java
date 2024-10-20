package calculator.domain;

import static calculator.common.Constants.BLANK_NUMBER;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final List<Number> numbers;

    public Numbers(String input) {
        this.numbers = extractNumbers(input);
    }

    private List<Number> extractNumbers (String input) {
        List<Number> extractedNumbers = new ArrayList<>();

        if (input.isBlank()) {
            Number number = new Number(BLANK_NUMBER);
            extractedNumbers.add(number);
        }

        return extractedNumbers;
    }

    public Integer size () {
        return numbers.size();
    }

    public Boolean compareNumber (Integer idx, Number number) {
        return number.equals(numbers.get(idx));
    }

}
