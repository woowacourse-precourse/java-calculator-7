package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAdditionCalculator {
    private static final String SEPARATOR_PATTERN = "//(.+)\\\\n";
    private static final String NUMBER_PATTERN = "[0-9]+";
    private static final String CUSTOM_SEPARATOR_STARTS = "//";
    private static final String DEFAULT_SEPARATOR = "[,:]";
    private static final String LINE_FEED_FOR_REGEX = "\\\\n";
    private static final String LINE_FEED = "\\n";

    private static final int SPLIT_COUNT = 2;
    private static final int NUMBER_STRING_INDEX = 1;

    public static int calc(String addition) {
        boolean customSeparatorDefined = addition.startsWith(CUSTOM_SEPARATOR_STARTS) && addition.contains(LINE_FEED);
        System.out.println(addition.startsWith(CUSTOM_SEPARATOR_STARTS));

        String separator = customSeparatorDefined ? getSeparator(addition) : DEFAULT_SEPARATOR;
        String numbersString = customSeparatorDefined ? addition.split(LINE_FEED_FOR_REGEX, SPLIT_COUNT)[NUMBER_STRING_INDEX] : addition;

        int[] numbers =  getNumbers(numbersString, separator);
        return Arrays.stream(numbers)
                .sum();
    }

    private static int[] getNumbers(String input, String separator) {
        String[] tokens = input.split(separator);

        return Arrays.stream(tokens)
                .peek(StringAdditionCalculator::validateNumber)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static void validateNumber(String number) {
        if (!number.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
        }
    }

    private static String getSeparator(String input) {
        Matcher matcher = Pattern.compile(SEPARATOR_PATTERN)
                .matcher(input);

        if (matcher.find()) {
            return matcher.group(1);
        }

        return DEFAULT_SEPARATOR;
    }
}
