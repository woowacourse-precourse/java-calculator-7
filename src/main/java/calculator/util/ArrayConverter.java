package calculator.util;

public class ArrayConverter {
    private static final String BASE_REGEX = "[:,]";
    private static final String EMPTY = "";

    public char[] toCharArrayWithoutDelimiter(String positiveString, String customDelimiter) {
        String positives = removeDelimiter(positiveString, customDelimiter);
        return positives.toCharArray();
    }

    private String removeDelimiter(String positiveString, String customDelimiter) {
        positiveString = positiveString.replaceAll(BASE_REGEX, EMPTY);
        return positiveString.replaceAll(customDelimiter, EMPTY);
    }

    public int[] convertCharArrayToIntArray(char[] chars) {
        return new String(chars)
                .chars()
                .map(Character::getNumericValue)
                .toArray();
    }
}
