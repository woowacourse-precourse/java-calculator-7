package calculator;

import org.junit.platform.commons.util.StringUtils;

import java.util.regex.Pattern;

public class StringSumCalculator {
    public int add(String input) {
        if (StringUtils.isBlank(input)) {
            return 0;
        }

        String[] numbers = splitNumbers(input);

        int sum = 0;
        for (String number : numbers) {
            String trim = number.trim();
            validateInput(trim);
            sum += positiveNumber(Integer.parseInt(trim));
        }
        return sum;
    }

    private String[] splitNumbers(String input) {
        input = input.replace("\\n", "\n");

        if (!input.startsWith("//") || !input.contains("\n")) {
            return input.split(",|:");
        }

        int delimiterIdx = input.indexOf("\n");
        String customDelimiters = input.substring(2, delimiterIdx);
        String numbersWithDelimiter = input.substring(delimiterIdx + 1);

        if (customDelimiters.startsWith("[") && customDelimiters.endsWith("]")) {
            String[] delimiters = customDelimiters.substring(1, customDelimiters.length() - 1).split("]\\[");
            String delimiterPattern = String.join("|", Pattern.quote(delimiters[0]), Pattern.quote(delimiters[1]));
            return numbersWithDelimiter.split(delimiterPattern);
        } else {
            return numbersWithDelimiter.split(Pattern.quote(customDelimiters));
        }
    }

    private int positiveNumber(Integer input) {

        if (input <= 0) {
            throw new IllegalArgumentException("양수 외에 불가. 다시 실행하시오.");
        }
        return input;
    }

    private void validateInput(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("잘못된 값 입력됨. 다시 실행하시오.");
        }
    }

}