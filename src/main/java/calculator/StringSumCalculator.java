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
            sum += parsePositiveNumber(number);
        }
        return sum;
    }

    private String[] splitNumbers(String input) {
        String[] splitNumbers;

        if (input.startsWith("//") && input.contains("\n")) {
            int delimiterIdx = input.indexOf("\n");
            String customDelimiter = input.substring(2, delimiterIdx);
            String numbersWithDelimiter = input.substring(delimiterIdx + 1);
            splitNumbers = numbersWithDelimiter.split(Pattern.quote(customDelimiter));
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
        if (!input.matches("//d+")) {
            throw new IllegalArgumentException("잘못된 값 입력됨. 다시 실행하시오.");
        }
    }

}