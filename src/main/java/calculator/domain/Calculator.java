package calculator.domain;

public class Calculator {

    public int add(String input) {
        String separator = ",:";
        if (isInputEmpty(input)) {
            return 0;
        }

        if (isCustomSeparator(input)) {
            separator = extractCustomSeparator(input, separator);
            input = extractNumbersPart(input);
        }

        String[] numbers = splitNumbers(input, separator);
        return calculateSum(numbers);
    }

    private boolean isInputEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private boolean isCustomSeparator(String input) {
        return input.startsWith("//");
    }

    private String extractCustomSeparator(String input, String separator) {
        int newlineIndex = input.indexOf("\\n");
        String customSeparator = input.substring(2, newlineIndex);
        return separator + customSeparator;
    }

    private String extractNumbersPart(String input) {
        return input.substring(input.indexOf("\\n") + 2);
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
