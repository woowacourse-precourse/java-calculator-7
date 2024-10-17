package calculator;

public class StringParser {
    public int[] parse(String input) {

        String delimiter = ", | :";
        String numbers = input;

        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf('\n');
            String customDelimiter = input.substring(2, delimiterEndIndex);
            delimiter = customDelimiter + delimiter;
            numbers = input.substring(delimiterEndIndex + 1);
        }
        return null;
    }
}
