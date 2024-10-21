package calculator.model;

import calculator.Utils.NumberValidator;
import java.util.ArrayList;
import java.util.List;

public class NumberParser {

    NumberValidator numberValidator = new NumberValidator();

    public List<Number> parse(String[] userInput) {
        List<Number> numbers = new ArrayList<>();
        for (String value : userInput) {
            numbers.add(parseSingleValue(value));
        }
        return numbers;
    }

    private Number parseSingleValue(String value) {

        if (numberValidator.isInt(value)) {
            return Integer.parseUnsignedInt(value);
        }
        if (numberValidator.isLong(value)) {
            return Long.parseUnsignedLong(value);
        }
        if (numberValidator.isDouble(value)) {
            return Double.parseDouble(value);
        }
        throw new IllegalArgumentException();
    }
}
