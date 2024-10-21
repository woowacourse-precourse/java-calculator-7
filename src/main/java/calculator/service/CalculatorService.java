package calculator.service;

import calculator.domain.CustomDelimiter;
import calculator.domain.Numbers;
import calculator.domain.validation.NumberInputValidator;
import calculator.util.InputFilter;
import calculator.util.Parser;
import java.util.ArrayList;
import java.util.List;

public class CalculatorService {

    private static final NumberInputValidator numberInputValidator = new NumberInputValidator();
    private static final int DEFAULT_SIZE = 1;
    private static final int CUSTOM_SIZE = 3;

    public Numbers extractNumbers(String input) {
        InputFilter.doOutWrong(input);
        String[] elements = Parser.splitOutByCustomStyle(input);

        List<String> numberInputs = splitWithDelimiter(elements);
        Numbers numbers = validateAndParse(numberInputs);

        return numbers;
    }

    private Numbers validateAndParse(List<String> splitNumbers) {
        List<Integer> numberList = splitNumbers
                .stream()
                .filter(input -> !input.trim().isEmpty())
                .map(numberInputValidator::validateOnlyNumeric)
                .toList();

        return new Numbers(numberList);
    }

    private List<String> splitWithDelimiter(String[] elements) {
        List<String> numbers = new ArrayList<>();

        if (elements.length == CUSTOM_SIZE) {
            CustomDelimiter delimiter = new CustomDelimiter(elements[1]);
            numbers = Parser.parseToCustom(delimiter, elements);
        }

        if (elements.length == DEFAULT_SIZE) {
            numbers = Parser.parseToDefault(elements);
        }

        return numbers;
    }
}