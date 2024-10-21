package calculator;

public class InputParser {
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static String customDelimiter;

    public int[] parse(String input, Validator validator) {
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX) && input.contains(CUSTOM_DELIMITER_SUFFIX)) {
            extractCustomDelimiter(input);
            input = removeCustomDelimiter(input);
            validator.validateCustomInput(input, customDelimiter);
        } else {
            validator.validateDefaultInput(input);
        }
        return parseInteger(input);
    }

    private String removeCustomDelimiter(String input) {
        return input.substring(input.indexOf(CUSTOM_DELIMITER_SUFFIX) + 2);
    }

    private void extractCustomDelimiter(String input) {
        customDelimiter = input.substring(2, input.indexOf(CUSTOM_DELIMITER_SUFFIX));
        Validator.validateCustomDelimiter(customDelimiter);
    }

    private int[] parseInteger(String input) {
        int[] numbers = new int[input.length()];
        String[] stringNumbers = input.split(DEFAULT_DELIMITERS + "|" + customDelimiter);

        for (int i = 0; i < stringNumbers.length; i++) {
            if (Validator.isEmptyString(stringNumbers[i])) {
                continue;
            }
            numbers[i] = Integer.parseInt(stringNumbers[i]);
        }
        return numbers;
    }
}
