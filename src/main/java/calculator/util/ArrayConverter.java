package calculator.util;

public class ArrayConverter {
    private static final String BASE_REGEX = "[:,]";
    private static final String EMPTY = "";

    private final NumberValidator numberValidator;

    public ArrayConverter(NumberValidator numberValidator) {
        this.numberValidator = numberValidator;
    }

    public char[] toCharArrayWithoutDelimiter(String positiveString, String customDelimiter) {
        String positives = removeDelimiter(positiveString, customDelimiter);
        return positives.toCharArray();
    }

    private String removeDelimiter(String positiveString, String customDelimiter) {
        positiveString = positiveString.replaceAll(BASE_REGEX, EMPTY);
        return positiveString.replace(customDelimiter, EMPTY);
    }

    public int[] convertCharArrayToIntArray(char[] chars) {
        numberValidator.validateNoDigits(chars); // 숫자 변환 가능한 문자 검사
        return new String(chars)
                .chars()
                .map(Character::getNumericValue)
                .toArray();
    }
}
