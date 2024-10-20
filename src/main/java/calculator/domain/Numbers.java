package calculator.domain;

import static calculator.common.Constants.BASIC_SEPARATOR;
import static calculator.common.Constants.BLANK_NUMBER;
import static calculator.common.Constants.FIRST_NUM_IDX;
import static calculator.common.Constants.SEPARATOR_IDX;
import static calculator.common.InputValidator.isBasicSeparator;
import static calculator.common.InputValidator.isCustomSeparator;

import java.util.ArrayList;
import java.util.Arrays;
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
        else if (isCustomSeparator(input)) {
            String extractedStr = input.substring(FIRST_NUM_IDX);
            String separator = String.valueOf(input.charAt(SEPARATOR_IDX));

            extractedNumbers = extractNumbers(extractedStr, separator);
        }
        else if (isBasicSeparator(input)) {
            extractedNumbers = extractNumbers(input, BASIC_SEPARATOR);
        }

        return extractedNumbers;
    }

    private List<Number> extractNumbers (String input, String separator) {
        String[] parts = input.split(separator);

        return Arrays.stream(parts)
                .map(Integer::parseInt)
                .map(Number::new)
                .toList();
    }

    public Integer size () {
        return numbers.size();
    }

    public Boolean compareNumber (Integer idx, Number number) {
        return number.equals(numbers.get(idx));
    }

}
