package calculator.service;

import calculator.utils.Validator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorService {
    private static final Pattern CUSTOM_SEPARATOR_REGEX = Pattern.compile("//(.*)\\\\n(.*)");
    private String[] tokens;

    public void separate(List<String> separators, String expression) {
        String cleanedExpression = expression.replaceAll("\\s+", "");
        String customSeparator = extractCustomSeparator(cleanedExpression);

        if (customSeparator != null) {
            separators.add(customSeparator);
        }

//        this.tokens = cleanedExpression.split(String.join("|", separators));
//        validateIsNumber(tokens);
//        validateIsPositiveNumber(tokens);
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

    private void validateIsNumber(String[] tokens) {
        Validator.isNumber(tokens);
    }

    private void validateIsPositiveNumber(String[] tokens) {
        Validator.isPositiveNumber(tokens);
    }

}
