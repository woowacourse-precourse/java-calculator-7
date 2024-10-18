package calculator.util;

public class ArrayConverter {
    public static final String EMPTY = "";
    public static final String BASE_REGEX = "[:,]";

    public char[] toCharArrayWithoutDelimiter(String positiveString, String customDelimiter) {
        String positives = removeDelimiter(positiveString, customDelimiter);
        return positives.toCharArray();
    }

    private String removeDelimiter(String positiveString, String customDelimiter) {
        positiveString = positiveString.replaceAll(BASE_REGEX, EMPTY);
        return positiveString.replaceAll(customDelimiter, EMPTY);
    }

    public int[] convertCharArrayToIntArray(char[] positiveCharArray) {
        return new String(positiveCharArray)
                .chars()
                .map(Character::getNumericValue)
                .toArray();
    }
}
