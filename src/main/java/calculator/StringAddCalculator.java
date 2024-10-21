package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String PATTERN = "[,:]";
    private static final String CUSTOM_PATTERN = "//(.)\\\\n(.*)";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_PATTERN);
    private static final int EMPTY_VALUE = 0;
    private static final int PATTERN_IN_GROUP = 1;
    private static final int NUMBERS_IN_GROUP = 2;

    public int calculate(String input) {
        return validateEmptyValue(input) ? EMPTY_VALUE : splitAndSumNumber(input);
    }

    private int splitAndSumNumber(String input) {
        return Arrays.stream(convertToIntArray(splitString(input))).sum();
    }

    private String[] splitString(String input) {
        String pattern = PATTERN;
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);

        if (matcher.find()) {
            pattern = matcher.group(PATTERN_IN_GROUP);
            input = matcher.group(NUMBERS_IN_GROUP);
        }

        return input.split(pattern);
    }

    private int[] convertToIntArray(String[] inputArray) {
        int[] numArray = new int[inputArray.length];

        for (int i = 0; i < inputArray.length; i++) {
            try {
                int num = Integer.parseInt(inputArray[i]);

                if (num < 0) {
                    throw new IllegalArgumentException(ErrorSubstance.NEGATIVE_NUM_AVAILABLE.getMessage());
                }

                numArray[i] = num;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorSubstance.INVALID_STRING.getMessage());
            }
        }

        return numArray;
    }

    private boolean validateEmptyValue(String input) {
        return input == null || input.isBlank();
    }
}
