package calculator.domain;

import calculator.util.Utils;
import calculator.validation.Validation;

import java.util.Arrays;

public class Calculator {
    private static final String DEFAULT_DELIMITERS = ",:";
    private static final String REGEX_OPEN_BRACKET = "[";
    private static final String REGEX_CLOSE_BRACKET = "]";
    private static final String CUSTOM_DELIMITER_START = "//";
    private static final String CUSTOM_DELIMITER_END = "\\n";
    private static final String NOT_DELIMITER = "";

    private static final int CUSTOM_DELIMITER_START_INDEX = 2;
    private static final int CUSTOM_DELIMITER_END_LENGTH = 2;
    private static final int NOT_FOUND_INDEX = -1;

    private int[] numbers;
    public Calculator(String inputString) {
        String[] splitStringArr = splitStringToArray(inputString);
        Validation.validateStringArrayToIntegerArray(splitStringArr);
        this.numbers = Utils.stringToIntegerArray(splitStringArr);
    }

    public int getCalculateResult(){
        return Utils.calculateArraySum(numbers);
    }

    private String[] splitStringToArray(String input){
        String customDelimiter = getCustomDelimiterString(input);
        String regex = getSplitRegex(customDelimiter);

        String cleanedInput = deleteCustomDelimiterString(input);
        return Arrays.stream(cleanedInput.split(regex))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toArray(String[]::new);
    }

    private String getSplitRegex(String customDelimiter){
        return REGEX_OPEN_BRACKET
                + customDelimiter + DEFAULT_DELIMITERS
                + REGEX_CLOSE_BRACKET;
    }

    private String getCustomDelimiterString(String input){
        if(hasCustomDelimiter(input)){
            int customDelimiterEndIndex = findCustomDelimiterEndIndex(input);
            String delimiter = input.substring(CUSTOM_DELIMITER_START_INDEX, customDelimiterEndIndex);
            Validation.validateDelimiter(delimiter);
            return delimiter;
        }
        return NOT_DELIMITER;
    }

    private boolean hasCustomDelimiter(String input){
        return hasCustomDelimiterStart(input) && hasCustomDelimiterEnd(input);
    }

    private String deleteCustomDelimiterString(String input){
        return hasCustomDelimiter(input) ? input.substring(getFirstIndexAfterDelimiter(input)) : input;
    }
    private int getFirstIndexAfterDelimiter(String input){
        return input.indexOf(CUSTOM_DELIMITER_END)+CUSTOM_DELIMITER_END_LENGTH;
    }

    private int findCustomDelimiterEndIndex(String input){
        return input.indexOf(CUSTOM_DELIMITER_END);
    }

    private boolean hasCustomDelimiterEnd(String input){
        return findCustomDelimiterEndIndex(input) != NOT_FOUND_INDEX;
    }

    private boolean hasCustomDelimiterStart(String input){
        return input.startsWith(CUSTOM_DELIMITER_START);
    }


}
