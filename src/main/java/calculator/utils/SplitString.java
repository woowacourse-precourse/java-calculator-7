package calculator.utils;

public class SplitString {
    private static final String defaultDelimiter = ",|:";

    public static String[] splitInput(String input) {
        String delimiter = defaultDelimiter;

        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\\n");
            String customDelimiter = input.substring(2, delimiterIndex);
            delimiter = customDelimiter;

            input = input.substring(delimiterIndex + 2);
        }

        return input.split(delimiter);
    }
}
