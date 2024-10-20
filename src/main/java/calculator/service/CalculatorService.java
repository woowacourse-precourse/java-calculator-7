package calculator.service;

import calculator.utils.Validator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorService {
    private static final Pattern CUSTOM_SEPARATOR_REGEX = Pattern.compile("//(.*)\\\\n(.*)");
    private String[] tokens;

    public void separate(String[] separators, String expression) {
        String cleanedExpression = expression.replaceAll("\\s+", "");
        customSeparate(cleanedExpression);

//        this.tokens = cleanedExpression.split(String.join("|", separators));
//        validateIsNumber(tokens);
//        validateIsPositiveNumber(tokens);
    }

    private void customSeparate(String expression) {
        Matcher matcher = CUSTOM_SEPARATOR_REGEX.matcher(expression);
        if (hasCustomSeparator(expression, matcher)) {
            String customSeparator = extractCustomSeparator(matcher);
            validateSingleCharacterSeparator(customSeparator);
        }

    }

    private String extractCustomSeparator(Matcher matcher) {
        System.out.println(matcher.group(1));
        return matcher.group(1);
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
