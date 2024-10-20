package calculator.service;

import calculator.utils.Validator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorService {
    private static final Pattern CUSTOM_SEPARATOR_REGEX = Pattern.compile("//(.*)\\\\n(.*)");

    public String getCustomSeparator(String expression) {
        String cleanedExpression = removeSpace(expression);
        return extractCustomSeparator(cleanedExpression);
    }

    public int[] separate(List<String> separators, String expression) {
        String cleanedExpression = removeSpace(expression);
        String[] tokens = cleanedExpression.split(String.join("|", separators));

        validateStartPositiveNumber(tokens[0]);
        validateIsNumber(tokens);
        validateIsPositiveNumber(tokens);

        return convertToIntArray(tokens);
    }

    private String removeSpace(String expression) {
        return expression.replaceAll("\\s+", "");
    }

    private int[] convertToIntArray(String[] tokens) {
        int[] numbers = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            numbers[i] = Integer.parseInt(tokens[i]);
        }
        return numbers;
    }

    private String extractCustomSeparator(String expression) {
        Matcher matcher = CUSTOM_SEPARATOR_REGEX.matcher(expression);
        if (hasCustomSeparator(expression, matcher)) {
            String customSeparator = matcher.group(1);
            validateSingleCharacterSeparator(customSeparator);
            return customSeparator;
        }
        return null;
    }

    private boolean hasCustomSeparator(String expression, Matcher matcher) {
        if (expression.startsWith("//") && matcher.find()) {
            return true;
        }
        return false;
    }

    private void validateSingleCharacterSeparator(String separator) {
        Validator.validateSingleCharacterSeparator(separator);
    }

    public String removeCustomSeparatorDefinition(String expression) {
        Matcher matcher = CUSTOM_SEPARATOR_REGEX.matcher(expression);
        if (matcher.find()) {
            return matcher.group(2);
        }
        return expression;
    }

    private void validateIsNumber(String[] tokens) {
        Validator.isNumber(tokens);
    }

    private void validateIsPositiveNumber(String[] tokens) {
        Validator.isPositiveNumber(tokens);
    }

    private void validateStartPositiveNumber(String startToken) {
        Validator.startPositiveNumber(startToken);
    }

}
