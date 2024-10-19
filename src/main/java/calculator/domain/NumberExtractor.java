package calculator.domain;

import calculator.validator.CalculatorValidator;

import java.util.ArrayList;
import java.util.List;

public class NumberExtractor {

    private final StringSplitter stringSplitter;

    public NumberExtractor(StringSplitter stringSplitter) {
        this.stringSplitter = stringSplitter;
    }

    public List<Integer> getNumbers(String stringToAdd) {
        String[] numberStrings = stringSplitter.getNumberStringsToAdd(stringToAdd);
        return parse(numberStrings);
    }

    private List<Integer> parse(String[] numberStrings) {
        List<Integer> numbers = new ArrayList<>();

        for (String numberString : numberStrings) {
            CalculatorValidator.validateNumbers(numberString);
            int num = Integer.parseInt(numberString);
            numbers.add(num);
        }
        return numbers;
    }
}
