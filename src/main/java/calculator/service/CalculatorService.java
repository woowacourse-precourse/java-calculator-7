package calculator.service;

import calculator.domain.CustomDelimiter;
import calculator.domain.Numbers;
import calculator.domain.validation.NumberInputValidator;
import calculator.util.InputFilter;
import calculator.util.Splitter;
import java.util.ArrayList;
import java.util.List;

public class CalculatorService {

    private static final NumberInputValidator numberInputValidator = new NumberInputValidator();

    private static final int DEFAULT_SIZE = 1;
    private static final int CUSTOM_SIZE = 3;

    public Numbers extractNumbers(String input) {
        InputFilter.doOutWrong(input);
        String[] splitValues = Splitter.splitOut(input);

        List<String> splitNumbers = splitWithDelimiter(splitValues);
        Numbers numbers = validateAndParse(splitNumbers);

        return numbers;
    }

    private Numbers validateAndParse(List<String> splitNumbers) {
        List<Integer> numberList = splitNumbers
                .stream()
                .map(numberInputValidator::validateOnlyNumeric)
                .toList();

        return new Numbers(numberList);
    }

    private List<String> splitWithDelimiter(String[] splitValues) {
        List<String> numbers = new ArrayList<>();

        if (splitValues.length == CUSTOM_SIZE) {
            CustomDelimiter delimiter = new CustomDelimiter(splitValues[1]);
            numbers = Splitter.splitToCustom(delimiter, splitValues);
        }

        if (splitValues.length == DEFAULT_SIZE) {
            numbers = Splitter.splitToDefault(splitValues);
        }

        return numbers;
    }
}