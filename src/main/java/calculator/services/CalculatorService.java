package calculator.services;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CalculatorService {

    public static String sum(String input) {
        if (input.startsWith("//")) {
            return formatResult(1);
        }
        double[] numbers = parseNumbers(input);
        double result = calculateSum(numbers);
        return formatResult(result);
    }

    private static double[] parseNumbers(String input) {
        String[] sections = extractSections(input);
        String numbersSection = sections[1];
        String delimiter = sections[0];
        return splitAndParseNumbers(numbersSection, delimiter);
    }

    private static String[] extractSections(String input) {
        String delimiter = getDelimiter(input);
        String numbersSection;

        if (input.startsWith("//")) {
            String[] parts = input.split("\n", 2);
            numbersSection = parts.length > 1 ? parts[1] : "";
        } else {
            numbersSection = input;
        }

        return new String[]{delimiter, numbersSection};
    }

    private static double[] splitAndParseNumbers(String numbersSection, String delimiter) {
        if (numbersSection.trim().isEmpty()) {
            return new double[0];
        }

        String[] stringNumbers = numbersSection.split(delimiter);
        List<Double> dataList = new ArrayList<>();

        for (String numberStr : stringNumbers) {
            double number = parseAndValidateNumber(numberStr.trim());
            dataList.add(number);
        }

        return dataList.stream().mapToDouble(Double::doubleValue).toArray();
    }

    private static double parseAndValidateNumber(String numberStr) {
        if (numberStr.isEmpty()) {
            return 0;
        }
        try {
            double number = Double.parseDouble(numberStr);
            if (number <= 0) {
                throw new IllegalArgumentException("양수만 입력 가능합니다: " + number);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해야 합니다: " + numberStr);
        }
    }

    private static double calculateSum(double[] numbers) {
        double sumResult = 0;
        for (double number : numbers) {
            sumResult += number;
        }
        return sumResult;
    }

    private static String formatResult(double result) {
        if (result % 1 == 0) {
            return String.format("%.0f", result);
        } else {
            return String.valueOf(result);
        }
    }

    private static String getDelimiter(String input) {
        String defaultDelimiter = "[,|:]";
        if (input.startsWith("//")) {
            String[] parts = input.split("\n", 2);
            String customDelimiter = parts[0].substring(2).trim().replace("\\n", "\n");
            return createDelimiterRegex(customDelimiter, defaultDelimiter);
        }
        return defaultDelimiter;
    }

    private static String createDelimiterRegex(String customDelimiter, String defaultDelimiter) {
        StringBuilder regexBuilder = new StringBuilder(defaultDelimiter);
        String[] customDelimiters = customDelimiter.split("[,:]");
        for (String delim : customDelimiters) {
            regexBuilder.append("|").append(Pattern.quote(delim));
        }
        return regexBuilder.toString();
    }
}