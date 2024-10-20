package calculator.service;

import calculator.exception.ErrorCode;
import calculator.model.separator.CustomSeparator;
import calculator.model.separator.DefaultSeparator;
import calculator.model.separator.Separator;

public class CalculatorService {
    private static final int MIN_NUMBER = 1;

    private static void validateInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorCode.EMPTY_INPUT.getMessage());
        }
    }

    private static int calculatePrefixSum(String input, String separator) {
        String prefix = input.substring(0, input.indexOf(CustomSeparator.getStartOfSeparator())).trim();
        return sumNumbers(prefix.split(separator));
    }

    private static String updateInputString(String input) {
        int separatorIndex = input.indexOf(CustomSeparator.getEndOfSeparator());
        return input.substring(separatorIndex + 2);
    }

    private static int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            if (!number.trim().isEmpty()) {
                try {
                    int num = Integer.parseInt(number.trim());
                    if (num < MIN_NUMBER) {
                        throw new IllegalArgumentException(ErrorCode.NON_POSITIVE_NUMBER.getMessage());
                    }
                    sum += num;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException(ErrorCode.INVALID_NUMBER_FORMAT.getMessage());
                }
            }
        }
        return sum;
    }

    public int add(String input) {
        validateInput(input);

        Separator separator = new DefaultSeparator();
        int sum = 0;

        while (input.contains(CustomSeparator.getStartOfSeparator())) {
            separator = CustomSeparator.extractAndCombine(input, separator.getSeparator());
            sum += calculatePrefixSum(input, separator.getSeparator());
            input = updateInputString(input);
        }

        sum += sumNumbers(input.split(separator.getSeparator()));
        return sum;
    }
}
