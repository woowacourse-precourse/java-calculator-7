package calculator.domain;

import calculator.validator.InputValidator;
import calculator.validator.NegativeNumberValidator;
import calculator.util.SeparatorExtractor;

public class Calculator {

    public int add(String input) {
        if (isInputEmpty(input)) {
            return 0;
        }

        String separator = SeparatorExtractor.extractSeparators(input);
        input = SeparatorExtractor.extractNumbersPart(input);

        InputValidator.validateInput(input, separator);

        String[] numbers = splitNumbers(input, separator);
        return calculateSum(numbers);
    }

    private boolean isInputEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private String[] splitNumbers(String input, String separator) {
        for (char tempSeparator : separator.toCharArray()) {
            input = input.replace(String.valueOf(tempSeparator), " ");
        }
        return input.split("\\s+");
    }

    private int calculateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            int parseNumber = Integer.parseInt(number);
            NegativeNumberValidator.validateNegativeNumber(parseNumber);
            sum += parseNumber;
        }
        return sum;
    }
}
