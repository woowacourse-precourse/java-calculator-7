package parser;

public class NumberParser {
    public String[] parseNumbers(String input, String delimiter) {
        if (input.startsWith("//")) {
            int numberStartIndex = input.indexOf("\n") + 1;
            input = input.substring(numberStartIndex);
        }
        return input.split(delimiter);
    }
}
