package calculator;


import java.util.regex.Pattern;

public class InputParser {
    private static final String DEFAULT_DELIMITER = ",|:";

    public String[] parse(String input) {
        String delimiter = DEFAULT_DELIMITER;
        input = input.replace("\\n", "\n");

        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\n");
            delimiter = input.substring(2, delimiterIndex);
            input = input.substring(delimiterIndex + 1);
            delimiter = DEFAULT_DELIMITER + "|" + Pattern.quote(delimiter);
        }
        return input.split(delimiter);
    }
}
