package calculator.calculator;

public class InputParser {
    public static String[] parse(String input) {
        String delimiter = ",|:";

        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException();
            }
            delimiter = input.substring(2, delimiterEndIndex);
            delimiter = escapeSpecialCharacters(delimiter);
            input = input.substring(delimiterEndIndex + 2);
        }

        return input.split(delimiter);
    }

    private static String escapeSpecialCharacters(String delimiter) {
        return java.util.regex.Pattern.quote(delimiter);
    }
}
