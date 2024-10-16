package calculator.domain;

import calculator.util.Utils;
import calculator.validation.Validation;

import java.util.Arrays;
import java.util.List;

public class Calculator {
    private static final String DEFAULT_DELIMITERS = ",:";
    private static final String REGEX_OPEN_BRACKET = "[";
    private static final String REGEX_CLOSE_BRACKET = "]";
    private static final String CUSTOM_DELIMITER_START = "//";
    private static final String CUSTOM_DELIMITER_END = "\\n";

    private static final int DELIMITER_START_INDEX = 2;

    private int[] numbers;
    public Calculator(String inputString) {
        String[] splitStringArr = splitStringToArray(inputString);
        Validation.validateStringArrToIntegerArr(splitStringArr);
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
            String delimiter = input.substring(DELIMITER_START_INDEX, customDelimiterEndIndex);
            Validation.validateDelimiterLength(delimiter);
            return delimiter;
        }
        return "";
    }

    private boolean hasCustomDelimiter(String input){
        return hasCustomDelimiterStart(input) && hasCustomDelimiterEnd(input);
    }

    private String deleteCustomDelimiterString(String input){
        return input.substring(getFirstIndexAfterDelimiter(input));
    }
    private int getFirstIndexAfterDelimiter(String input){
        return input.indexOf(CUSTOM_DELIMITER_END)+2;
    }

    private int findCustomDelimiterEndIndex(String input){
        return input.indexOf(CUSTOM_DELIMITER_END);
    }

    private boolean hasCustomDelimiterEnd(String input){
        return findCustomDelimiterEndIndex(input) != -1;
    }

    private boolean hasCustomDelimiterStart(String input){
        return input.startsWith(CUSTOM_DELIMITER_START);
    }


}
