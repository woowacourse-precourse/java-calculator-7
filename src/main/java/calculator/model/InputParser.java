package calculator.model;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {
    private String delimiter;
    private String expression;

    public int[] extractOperands(String userInput) {
        if (userInput.isEmpty() || userInput == null) {
            return new int[]{0};
        }
        updateDelimiterAndExpression(userInput);
        return extractNumbersFromExpression(expression, delimiter);
    }

    private void updateDelimiterAndExpression(String userInput) {
        if (hasCustomDelimiterIn(userInput)) {
            expression = extractExpression(userInput);
            delimiter = "[.:" + extractDelimiter(userInput) + "]";
        } else {
            expression = userInput;
            delimiter = "[,:]";
        }
    }

    public String extractExpression(String userInput) {
        return userInput.replaceAll("//.\\\\n", "");
    }

    public String extractDelimiter(String userInput) {
        Matcher matcher = Pattern.compile("//(.)\\\\n").matcher(userInput);
        matcher.find(); //??????
        return matcher.group(1);
    }

    public boolean hasCustomDelimiterIn(String userInput) {
        return userInput.matches("//.\\\\n.*");
    }

    private int[] extractNumbersFromExpression(String expression, String delimiter) {
        String[] inputStringNumbers = parseUserInput(expression, delimiter);
        return changeStringArrayToIntegerArray(inputStringNumbers);
    }

    private String[] parseUserInput(String userInput, String delimiter) {
        return userInput.split(delimiter);
    }

    private int[] changeStringArrayToIntegerArray(String[] stringNumbers) {
        return Arrays.stream(stringNumbers)
                .mapToInt(number -> {
                    int intValue = Integer.parseInt(number);
                    if (intValue < 0) {
                        throw new IllegalArgumentException("Negative numbers are not allowed: " + intValue);
                    }
                    return intValue;
                })
                .toArray();
    }
}
