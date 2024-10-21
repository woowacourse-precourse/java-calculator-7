package calculator.services;

import java.util.ArrayList;
import java.util.List;

public class CalculatorService {

    public static String sum(String input) {
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
        String delimiter = "[,:]";
        String inputData = "";

        if (input.startsWith("//")) {
            int newLineIndex = input.indexOf("\\n");
            if (newLineIndex != -1) {
                String customDelimiter = input.substring(2, newLineIndex);
                delimiter = customDelimiter + "|" + delimiter;
                inputData = input.substring(newLineIndex + 2);
            }
        } else {
            inputData = input;
        }

        return new String[]{delimiter, inputData};
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
            throw new IllegalArgumentException();
        }
        try {
            double number = Double.parseDouble(numberStr);
            if (number <= 0) {
                throw new IllegalArgumentException();
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
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
}
