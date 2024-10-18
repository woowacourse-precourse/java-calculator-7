package calculator.calculator;


import calculator.util.CustomDelimiterExtractor;
import calculator.util.InputValidator;
import calculator.util.NumberExtractor;
import calculator.util.NumberSummer;

import static calculator.util.DelimiterConstants.CUSTOM_DELIMITER_END;
import static calculator.util.DelimiterConstants.DEFAULT_DELIMITERS;

public class Calculator {
    private final String input;

    public Calculator(String input) {
        this.input = input;
    }

    public int calculate() {
        String validatedInput = InputValidator.validate(input);

        if (isInputEmpty(validatedInput)) {
            return 0;
        }

        int[] numbers;

        if (isCustomDelimiter(validatedInput)) {
            numbers = extractNumbersWithCustomDelimiter(validatedInput);
        } else {
            numbers = extractNumbersWithDefaultDelimiter(validatedInput);
        }

        return NumberSummer.sum(numbers);
    }

    private boolean isInputEmpty(String input) {
        return input.equals("0");
    }

    private boolean isCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    private int[] extractNumbersWithCustomDelimiter(String input) {
        String customDelimiter = CustomDelimiterExtractor.extract(input);
        String numberPart = input.substring(input.indexOf(CUSTOM_DELIMITER_END) + 2);
        String[] delimiters = NumberExtractor.mergeDelimiters(customDelimiter);
        return NumberExtractor.extract(numberPart, delimiters);
    }

    private int[] extractNumbersWithDefaultDelimiter(String input) {
        return NumberExtractor.extract(input, DEFAULT_DELIMITERS);
    }
}