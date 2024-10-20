package calculator.command;

public class CommandReader {
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private static final int START_OF_USER_INPUT_INDEX = 0;

    public DelimiterLine readDelimiter(String userInput) {
        if (hasNoDelimiterString(userInput))
            return DelimiterLine.EMPTY_LINE;
        if(hasNoPrefix(userInput) || hasNoSuffix(userInput))
            throw new IllegalArgumentException("잘못된 형식의 구분자 입력");

        return new DelimiterLine(findDelimiter(userInput));
    }

    private static String findDelimiter(String userInput) {
        String delimiterLine = findDelimiterLine(userInput);
        return removeSurrounding(delimiterLine, CUSTOM_DELIMITER_PREFIX, CUSTOM_DELIMITER_SUFFIX);
    }

    private static boolean hasNoDelimiterString(String userInput) {
        return hasNoPrefix(userInput) && hasNoSuffix(userInput);
    }

    private static boolean hasNoSuffix(String userInput) {
        return !userInput.contains(CUSTOM_DELIMITER_SUFFIX);
    }

    private static boolean hasNoPrefix(String userInput) {
        return !userInput.contains(CUSTOM_DELIMITER_PREFIX);
    }

    private static String findDelimiterLine(String userInput) {
        return userInput.substring(START_OF_USER_INPUT_INDEX, findEndOfDelimiterLineIndex(userInput));
    }

    private static int findEndOfDelimiterLineIndex(String userInput) {
        if(userInput.contains(CUSTOM_DELIMITER_SUFFIX))
            return userInput.lastIndexOf(CUSTOM_DELIMITER_SUFFIX) + CUSTOM_DELIMITER_SUFFIX.length();
        return 0;
    }

    private static String removeSurrounding(String original, String prefix, String suffix) {
        return original.substring(
                original.indexOf(prefix) + prefix.length(),
                original.lastIndexOf(suffix)
        );
    }

    public NumbersLine readNumbers(String userInput) {
        if (hasWrongDelimiterLine(userInput))
            throw new IllegalArgumentException("잘못된 형식의 구분자 입력");

        String numbersLine = findNumbersLine(userInput);
        return new NumbersLine(numbersLine);
    }

    private static boolean hasWrongDelimiterLine(String userInput) {
        return !hasNoDelimiterString(userInput) && (hasNoPrefix(userInput) || hasNoSuffix(userInput));
    }

    private String findNumbersLine(String userInput) {
        return userInput.replace(findDelimiterLine(userInput), "");
    }
}
