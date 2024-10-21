package calculator;

public class Parser {
    public int[] parse(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessages.NULL_INPUT.getMessage());
        }

        String delimiter = getDelimiter(input);

        return parseNumbers(input, delimiter);
    }

    private static final String DEFAULT_DELIMITER_PREFIX = "//";
    private static final String DEFAULT_DELIMITER_SUFFIX = "\\n";
    private static final String DEFAULT_DELIMITER = ",:";

    private int inputIndex = 0;

    private boolean hasCustomDelimiter(String input) {
        return input != null && input.startsWith(DEFAULT_DELIMITER_PREFIX);
    }

    private String getCustomDelimiter(String input) {
        if (!hasCustomDelimiter(input)) {
            return "";
        }

        int indexOfSuffix = getIndexOfSuffix(input);

        char customDelimiter = input.charAt(DEFAULT_DELIMITER_PREFIX.length());
        inputIndex = indexOfSuffix + DEFAULT_DELIMITER_SUFFIX.length();
        if (DEFAULT_DELIMITER.indexOf(customDelimiter) != -1 || Character.isDigit(customDelimiter)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_CUSTOM_DELIMITER.getMessage());
        }

        return String.valueOf(customDelimiter);
    }

    private static int getIndexOfSuffix(String input) {
        int indexOfSuffix = input.indexOf(DEFAULT_DELIMITER_SUFFIX);
        if (indexOfSuffix == -1) {
            throw new IllegalArgumentException(ErrorMessages.NOT_EXIST_CUSTOM_DELIMITER_SUFFIX.getMessage());
        } else if (indexOfSuffix == DEFAULT_DELIMITER_PREFIX.length()) {
            throw new IllegalArgumentException(ErrorMessages.NOT_EXIST_CUSTOM_DELIMITER.getMessage());
        } else if (indexOfSuffix - DEFAULT_DELIMITER_PREFIX.length() > 1) {
            throw new IllegalArgumentException(ErrorMessages.MULTI_CUSTOM_DELIMITER.getMessage());
        }
        return indexOfSuffix;
    }

    private String getDelimiter(String input) {
        return DEFAULT_DELIMITER + getCustomDelimiter(input);
    }

    private void validateNumber(String number) {
            for (char c : number.toCharArray()) {
                if (!Character.isDigit(c)) {
                    throw new IllegalArgumentException(ErrorMessages.INVALID_NUMBER.getMessage());
                }
            }
    }

    private int[] convertToIntArray(String[] numbers) {
        int[] result = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            validateNumber(numbers[i]);
            result[i] = Integer.parseInt(numbers[i]);
        }
        return result;
    }

    private static String escapeForRegex(String str) {
        String regexSpecialChars = "([\\^$.|?*+(){}])";
        return str.replaceAll(regexSpecialChars, "\\\\$1");
    }

    private int[] parseNumbers(String input, String delimiter) {
        String[] numbers = input.substring(inputIndex).split("[" + escapeForRegex(delimiter) + "]");
        return convertToIntArray(numbers);
    }
}
