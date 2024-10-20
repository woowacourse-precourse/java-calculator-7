package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final String DEFAULT_DELIMITERS = "[,:]";
    private static final String CUSTOM_DELIMITER_PREFIX = "//(.+)\\\\n";
    private static final String POSITIVE_NUMBER_ERROR = "양수만 허용됩니다: ";
    private static final String INVALID_NUMBER_ERROR = "숫자가 아닌 값이 포함되어 있습니다: ";

    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        boolean Custom_Delimiter = Pattern.compile(CUSTOM_DELIMITER_PREFIX)
                .matcher(input)
                .find();
        String separation = Custom_Delimiter ? addWithCustomDelimiter(input) : DEFAULT_DELIMITERS;
        String numbersString = Custom_Delimiter ? input.split("\\\\n", 2)[1] : input;

        int[] numbers = parseInput(numbersString, separation);
        return Arrays.stream(numbers).sum();
    }

    private String addWithCustomDelimiter(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PREFIX)
                .matcher(input);
        if (matcher.find()) {
            return Pattern.quote(matcher.group(1));
        }
        return DEFAULT_DELIMITERS;
    }

    private int[] parseInput(String input, String separator) {
        return Arrays.stream(input.split(separator))
                .map(String::trim)
                .mapToInt(this::parseNumber)
                .toArray();
    }

    private int parseNumber(String token) {
        validateNumber(token);
        int number = Integer.parseInt(token);
        if (number < 0) {
            throw new IllegalArgumentException(POSITIVE_NUMBER_ERROR + number);
        }
        return number;
    }

    private void validateNumber(String number) {
        if (!number.matches("[0-9]+")) {
            throw new IllegalArgumentException(INVALID_NUMBER_ERROR + number);
        }
    }
}