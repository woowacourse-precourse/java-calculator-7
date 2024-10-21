package calculator.domain;

import calculator.global.validator.Validator;

public class NumberParser {
    private final DelimiterExtractor delimiterExtractor;

    public NumberParser() {
        this.delimiterExtractor = new DelimiterExtractor();
    }

    public String[] parse(String input) {
        String[] extractedData = delimiterExtractor.extract(input);
        String delimiter = extractedData[0];
        String numbers = extractedData[1];

        Validator.validateNotEmpty(numbers);

        String[] numberArray = numbers.split(delimiter);
        Validator.validateNumbers(numberArray);

        return numberArray;
    }
}