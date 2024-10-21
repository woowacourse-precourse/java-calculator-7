package calculator.service;

import calculator.exception.ErrorCode;
import calculator.model.separator.CustomSeparator;
import calculator.model.separator.DefaultSeparator;
import calculator.model.separator.Separator;

public class CalculatorService {
    private static final int NON_POSITIVE_THRESHOLD = 0;

    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        Separator separator = new DefaultSeparator();
        int sum = 0;

        while (input.contains(CustomSeparator.getStartOfSeparator())) {
            separator = CustomSeparator.extractInputAndCombineToSeparator(input, separator.getSeparator());
            sum += calculatePrefixSum(input, separator.getSeparator());
            input = updateInputString(input);
        }

        sum += sumNumbers(input.split(separator.getSeparator()));
        return sum;
    }

    private static int calculatePrefixSum(String input, String separator) {
        String prefix = input.substring(0, input.indexOf(CustomSeparator.getStartOfSeparator())).trim();
        return sumNumbers(prefix.split(separator));
    }

    private String updateInputString(String input) {
        int separatorIndex = input.indexOf(CustomSeparator.getEndOfSeparator());
        return input.substring(separatorIndex + 2);
    }

    private static int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            if (!number.trim().isEmpty()) {
                int num = validateNumber(number.trim());
                sum += num;
            }
        }
        return sum;
    }

    private static int validateNumber(String numberString) {
        try {
            int num = Integer.parseInt(numberString);
            if (num <= NON_POSITIVE_THRESHOLD) {
                throw new IllegalArgumentException(ErrorCode.NON_POSITIVE_NUMBER.getMessage());
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.INVALID_NUMBER_FORMAT.getMessage());
        }
    }
}
