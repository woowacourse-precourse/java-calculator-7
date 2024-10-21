package calculator.domain;

public class NumberParser {

    private String getSplittedString(String input) {
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            return input.substring(delimiterEndIndex + 1);
        }
        return input;
    }
}
