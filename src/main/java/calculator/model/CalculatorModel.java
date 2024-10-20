package calculator.model;

import java.util.Arrays;

public class CalculatorModel {
    public int calculate(String userInput) {
        DelimiterParser delimiterParser = new DelimiterParser();

        String delimiter = delimiterParser.extractDelimiter(userInput);
        String expression = delimiterParser.extractExpression(userInput);

        int[] inputIntegerNumbers = extractNumbersFromExpression(expression, delimiter);
        return sumAllNumbers(inputIntegerNumbers);
    }

    private int[] extractNumbersFromExpression(String extractedInput, String delimiter) {
        String[] inputStringNumbers = parseUserInput(extractedInput, delimiter);
        return changeStringArrayToIntegerArray(inputStringNumbers);
    }

    private int sumAllNumbers(int[] inputIntegerNumbers) {
        return Arrays.stream(inputIntegerNumbers).sum();
    }

    private int[] changeStringArrayToIntegerArray(String[] stringNumbers) {
        return Arrays.stream(stringNumbers).mapToInt(Integer::parseInt).toArray();
    }

    private String[] parseUserInput(String userInput, String delimiter) {
        return userInput.split(delimiter);
    }
}
