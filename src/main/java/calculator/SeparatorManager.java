package calculator;

public class SeparatorManager {

    static String initSeparator(String input, boolean hasCustomSeparator) {
        String basicSeparators = ",:";
        if (hasCustomSeparator) {
            char customSeparator = input.charAt(2);
            return basicSeparators + customSeparator;
        }
        return basicSeparators;
    }
}
