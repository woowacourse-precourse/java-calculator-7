package calculator;

import java.util.regex.Pattern;

public class InputValidator {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("^([0-9]+([.,][0-9]+)?)([,:][0-9]+([.,][0-9]+)*)*$");
    private static final String META_CHARACTERS = "{}[]()|^$.*+?\\";

    public void isInvalidFormat(String input) {
        if (!NUMBER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isCustomPattern(String input) {
        return input.startsWith("//");
    }

    private boolean isMetaCharacters(String customPattern) {
        return META_CHARACTERS.contains(customPattern);
    }

    public void isInvalidFormatCustomPattern(String customPattern, String numbers) {
        if (isMetaCharacters(customPattern)) {
            for (char metaChar : META_CHARACTERS.toCharArray()) {
                numbers = numbers.replaceAll(Pattern.quote(String.valueOf(metaChar)), ",");
            }
        }

        isInvalidFormat(numbers);
    }
}
