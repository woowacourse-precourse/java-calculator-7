package calculator.service.impl;

import static calculator.common.DelimiterConstant.CUSTOM_DELIMITER_PREFIX;
import static calculator.common.DelimiterConstant.CUSTOM_DELIMITER_SUFFIX;
import static calculator.common.InputStatus.*;

import calculator.common.InputStatus;
import calculator.service.ValidatorService;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorServiceImpl implements ValidatorService {
    @Override
    public InputStatus validateInput(String input) throws IllegalArgumentException {
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            int delimiterEndIndex = input.lastIndexOf(CUSTOM_DELIMITER_SUFFIX);
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("Invalid input format");
            }
            String customDelimiter = input.substring(2, delimiterEndIndex);
            if (customDelimiter.isEmpty()) {
                return EMPTY_CUSTOM_DELIMITER_STATUS;
            }
            return CUSTOM_DELIMITER_STATUS;
        }
        return DEFAULT_DELIMITERS_STATUS;
    }

    @Override
    public void validateDelimiterExpression(String delimiter, String expression) throws IllegalArgumentException {
        List<String> customDelimiters = getCustomDelimiters(delimiter);
        for (String customDelimiter : customDelimiters) {
            if (isNumeric(customDelimiter)) {
                throw new IllegalArgumentException("Custom delimiter cannot be a number: " + customDelimiter);
            }
        }
        if (expression.matches("^([" + delimiter + "]+).*") || expression.matches(".*([" + delimiter + "]+)$")) {
            throw new IllegalArgumentException("Input cannot start or end with a delimiter.");
        }
        if (expression.matches(".*([" + delimiter + "]{2,}).*")) {
            throw new IllegalArgumentException("Consecutive delimiters are not allowed.");
        }
        if (!delimiter.contains("-") && expression.contains("-")) {
            throw new IllegalArgumentException("Negative numbers are not allowed");
        }
    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static List<String> getCustomDelimiters(String delimiter) {
        Pattern pattern = Pattern.compile("\\\\Q(.*?)\\\\E");
        Matcher matcher = pattern.matcher(delimiter);

        List<String> customDelimiters = new ArrayList<>();

        while (matcher.find()) {
            customDelimiters.add(matcher.group(1));
        }

        return customDelimiters;
    }
}
