package calculator.util.refine;

import static calculator.util.refine.InputValidator.validateIsEmptyInput;
import static calculator.util.refine.InputValidator.validateIsInteger;
import static calculator.util.refine.InputValidator.validateNonNegativeNumber;

import java.util.ArrayList;
import java.util.List;

public class SeparatePositiveNumber {

    private final DelimiterExtractor delimiterExtractor;

    public SeparatePositiveNumber(DelimiterExtractor delimiterExtractor) {
        this.delimiterExtractor = delimiterExtractor;
    }

    public List<Integer> extractNumbers(String input) {
        validateIsEmptyInput(input);
        String delimiter = delimiterExtractor.extractDelimiter(input);
        input = delimiterExtractor.removeDelimiterDefinition(input);

        String[] tokens = input.split(delimiter);

        return toPositiveNumberList(tokens);
    }

    private List<Integer> toPositiveNumberList(String[] tokens) {
        List<Integer> numbers = new ArrayList<>();

        for (String token : tokens) {
            validateIsInteger(token);
            int number = Integer.parseInt(token);
            validateNonNegativeNumber(number);
            numbers.add(number);
        }

        return numbers;
    }
}