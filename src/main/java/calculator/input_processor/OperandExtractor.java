package calculator.input_processor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperandExtractor {

    private static final List<String> DEFAULT_DELIMITERS = List.of(",", ":");
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.+?)\\\\n");
    private static final Pattern EXPRESSION_PATTERN = Pattern.compile("\\\\n(.*)");

    public String[] extractOperand(String userInput) {
        List<String> delimiters = setUpDelimiters(userInput);
        String preprocessExp = preprocessExpression(userInput);
        String delimiterRegex = String.join("|", delimiters);
        return preprocessExp.split(delimiterRegex);
    }

    private List<String> setUpDelimiters(String userInput) {
        Matcher delimiterMatcher = CUSTOM_DELIMITER_PATTERN.matcher(userInput);
        List<String> delimiters = new ArrayList<>(DEFAULT_DELIMITERS);
        if (delimiterMatcher.find()) {
            delimiters.add(delimiterMatcher.group(1));
        }
        return delimiters;
    }

    private String preprocessExpression(String userInput) {
        Matcher expressionPatternMatcher = EXPRESSION_PATTERN.matcher(userInput);
        if (expressionPatternMatcher.find()) {
            return expressionPatternMatcher.group(1);
        }
        return userInput;
    }
}