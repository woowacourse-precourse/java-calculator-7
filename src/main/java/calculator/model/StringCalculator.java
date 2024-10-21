package calculator.model;

import calculator.exception.ErrorMessage;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }
        String[] numbers = splitNumbers(input);
        return sumNumbers(numbers);
    }

    private boolean isNullOrEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private String[] splitNumbers(String input) {
        String separator = ",|:";
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_CUSTOM_DELIMITER);
            }
            String customDelimiter = input.substring(2, delimiterEndIndex);
            separator = Pattern.quote(customDelimiter) + "|,|:";
            input = input.substring(delimiterEndIndex + 1);
        }
        if (input.isEmpty()) {
            return new String[0];
        }
        if (!Character.isDigit(input.charAt(input.length() - 1))) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_MUST_END_WITH_NUMBER);
        }
        return input.split(separator);
    }

    private int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            if (number.isEmpty()) {
                continue; // 빈 문자열은 무시합니다.
            }
            int num;
            try {
                num = Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC_VALUE + number);
            }
            if (num < 0) {
                throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER + num);
            }
            sum += num;
        }
        return sum;
    }
}
