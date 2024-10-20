package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAdditionCalculator {
    private static final String SEPARATOR_PATTERN = "//(.+)\\\\n";
    private static final String DEFAULT_SEPARATOR = "[,:]";

    public static int calc(String addition) {
        boolean customSeparatorDefined = Pattern.compile(SEPARATOR_PATTERN)
                .matcher(addition)
                .find();

        String separator = customSeparatorDefined ? getSeparator(addition) : DEFAULT_SEPARATOR;
        String numbersString = customSeparatorDefined ? addition.split("\\\\n", 2)[1] : addition;

        int[] numbers =  getNumbers(numbersString, separator);
        return Arrays.stream(numbers)
                .sum();
    }

private static int[] getNumbers(String input, String separator) {
    String[] tokens = input.split(separator);
    int[] numbers = new int[tokens.length];

    for (int i = 0; i < tokens.length; i++) {
        validateNumber(tokens[i]);
        numbers[i] = Integer.parseInt(tokens[i]);
    }

    return numbers;
}

    private static void validateNumber(String number) {
        if (!number.matches("[0-9]+")) {
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
