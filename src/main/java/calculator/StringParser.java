package calculator;

public class StringParser {
    public static String[] parseNumbers(String input) {
        if (input == null || input.isEmpty()) {
            return new String[0];
        }

        String delimiter = ",|:";
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\\n");
            delimiter = input.substring(2, delimiterIndex);
            input = input.substring(delimiterIndex + 2);
        }

        return input.split(delimiter);
    }
}
