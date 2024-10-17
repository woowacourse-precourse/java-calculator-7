package calculator.domain;

import calculator.exception.Validator;
import calculator.util.SeparatorExtractor;

public class Calculator {

    public int add(String input) {
        String separator = ",:";
        if (isInputEmpty(input)) {
            return 0;
        }

        String separator = SeparatorExtractor.extractSeparators(input);
        input = SeparatorExtractor.extractNumbersPart(input);

        Validator.validateInput(input, separator);

        String[] numbers = splitNumbers(input, separator);
        return calculateSum(numbers);
    }

    private boolean isInputEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private String[] splitNumbers(String input, String separator) {
        for (char delimiter : separator.toCharArray()) {
            input = input.replace(String.valueOf(delimiter), " ");
        }
        return input.split("\\s+");
    }

    private int calculateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += parseAndValidateNumber(number);
        }
        return sum;
    }

    private int parseAndValidateNumber(String number) {
        int parsedNumber = Integer.parseInt(number.trim());
        if (parsedNumber < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + parsedNumber);
        }
        return parsedNumber;
    }
}
