package calculator.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorService {

    public int calculate(String input) {
        if (isEmptyInput(input)) {
            return 0;
        }

        String customDelimiter = null;
        String numbers = input;

        if (hasCustomDelimiter(input)) {
            customDelimiter = extractCustomDelimiter(input);
            numbers = extractNumbersPart(input);
        }

        String[] splitNumbers = splitNumbers(numbers, customDelimiter);
        return calculateSum(splitNumbers);
    }

    private boolean isEmptyInput(String input) {
        return input == null || input.trim().isEmpty();
    }

    private boolean hasCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    private String extractCustomDelimiter(String input) {
        Matcher matcher = Pattern.compile("//(.)\n").matcher(input);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("잘못된 형식입니다.");
    }

    private String extractNumbersPart(String input) {
        Matcher matcher = Pattern.compile("//.\n(.*)").matcher(input);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("잘못된 형식입니다.");
    }

    private String[] splitNumbers(String numbers, String customDelimiter) {
        String[] defaultDelimiters = {",", ":"};
        String delimiterPattern = createDelimiterPattern(defaultDelimiters, customDelimiter);
        return numbers.split(delimiterPattern);
    }

    private String createDelimiterPattern(String[] defaultDelimiters, String customDelimiter) {
        StringBuilder patternBuilder = new StringBuilder();

        for (String delimiter : defaultDelimiters) {
            patternBuilder.append(Pattern.quote(delimiter)).append("|");
        }

        if (customDelimiter != null) {
            patternBuilder.append(Pattern.quote(customDelimiter)).append("|");
        }

        if (patternBuilder.length() > 0) {
            patternBuilder.setLength(patternBuilder.length() - 1);
        }

        return patternBuilder.toString();
    }

    private int calculateSum(String[] splitNumbers) {
        int sum = 0;
        for (String number : splitNumbers) {
            int parsedNumber = parseInteger(number);
            if (parsedNumber < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
            sum += parsedNumber;
        }
        return sum;
    }

    private int parseInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
        }
    }
}
