package calculator;

import java.util.regex.Pattern;

public class StringSumCalculator {
    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] numbers = splitNumbers(input);

        int sum = 0;
        for (String number : numbers) {
            validateInput(number.trim());
            sum += parsePositiveNumber(number);
        }
        return sum;
    }

    private String[] splitNumbers(String input) {
        input = input.replace("\\n", "\n");

        String[] splitNumbers;

        if (input.startsWith("//") && input.contains("\n")) {
            int delimiterIdx = input.indexOf("\n");
            String customDelimiters = input.substring(2, delimiterIdx);
            String numbersWithDelimiter = input.substring(delimiterIdx + 1);

            if (customDelimiters.startsWith("[") && customDelimiters.endsWith("]")) {
                String[] delimiters = customDelimiters.substring(1, customDelimiters.length() - 1).split("]\\[");
                String delimiterPattern = String.join("|", Pattern.quote(delimiters[0]), Pattern.quote(delimiters[1]));
                splitNumbers = numbersWithDelimiter.split(delimiterPattern);
            } else {
                splitNumbers = numbersWithDelimiter.split(Pattern.quote(customDelimiters));
            }
        } else {
            splitNumbers = input.split(",|:");
        }
        return splitNumbers;
    }

    private int parsePositiveNumber(String input) {
        int number = Integer.parseInt(input.trim());

        if (number < 0) {
            throw new IllegalArgumentException("음수 불가. 다시 실행하시오.");
        }
        return number;
    }

    private void validateInput(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("잘못된 값 입력됨. 다시 실행하시오.");
        }
    }

}