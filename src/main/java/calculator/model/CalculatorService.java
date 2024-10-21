package calculator.model;

import java.util.regex.Pattern;

public class CalculatorService {
    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] numbers = splitNumbers(input);
        return sumNumbers(numbers);
    }

    private String[] splitNumbers(String input) {
        String separator = ",|:";
        if (input.startsWith("//")) {
            String customDelimiter = parseCustomDelimiter(input);
            separator = Pattern.quote(customDelimiter) + "|,|:";
            input = extractNumbersSection(input);
        }
        if (input.isEmpty()) {
            return new String[0];
        }
        validateInputEndsWithNumber(input);
        return input.split(separator);
    }

    private String parseCustomDelimiter(String input) {
        int delimiterEndIndex = input.indexOf("\n");
        if (delimiterEndIndex == -1) {
            throw new IllegalArgumentException("커스텀 구분자 지정이 잘못되었습니다. '//구분자\\n숫자' 형식으로 입력해야 합니다.");
        }
        String customDelimiter = input.substring(2, delimiterEndIndex);
        if (customDelimiter.length() != 1) {
            throw new IllegalArgumentException("커스텀 구분자는 단일 문자여야 합니다.");
        }
        if (Character.isDigit(customDelimiter.charAt(0))) {
            throw new IllegalArgumentException("커스텀 구분자는 숫자일 수 없습니다.");
        }
        return customDelimiter;
    }

    private String extractNumbersSection(String input) {
        int delimiterEndIndex = input.indexOf("\n");
        return input.substring(delimiterEndIndex + 1);
    }

    private void validateInputEndsWithNumber(String input) {
        if (input.isEmpty()) {
            return;
        }
        if (!Character.isDigit(input.charAt(input.length() - 1))) {
            throw new IllegalArgumentException("입력은 반드시 숫자로 끝나야합니다.");
        }
    }

    private int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            int num = parseNumber(number);
            validateNonNegative(num);
            sum += num;
        }
        return sum;
    }

    private int parseNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + number);
        }
    }

    private void validateNonNegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수가 포함되어 계산불가: " + number);
        }
    }
}
