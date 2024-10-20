package calculator.util;

public class InputIntegerParser {
    private static final String NON_NUMBER_FORMAT_EXCEPTION_MESSAGE = "정수를 입력해주세요.";
    private InputIntegerParser() {
        throw new IllegalStateException("Utility class");
    }

    public static Integer[] parseInputToInteger(String[] splitString) {
        int length = splitString.length;
        Integer[] parsedNumbers = new Integer[length];
        try {
            for (int i = 0; i < length; i++) {
                parsedNumbers[i] = Integer.parseInt(splitString[i]);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMBER_FORMAT_EXCEPTION_MESSAGE);
        }
        return parsedNumbers;
    }
}
