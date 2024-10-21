package calculator;

import java.util.regex.Pattern;

public class CustomDelimiter {
    private static final String DEFAULT_DELIMITERS = "[,|:]";

    public String[] extractNumbers(String input) {
        String delimiter = getDelimiter(input);
        String numbersPart = getNumbersPart(input);
        System.out.println("numbersPart: " + numbersPart);
        return numbersPart.split(delimiter);
    }

    private String getDelimiter(String input) {
        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\\n");
            return Pattern.quote(input.substring(2, newlineIndex).trim());
        }
        return DEFAULT_DELIMITERS;
    }

    private String getNumbersPart(String input) {
        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\\n");
            return input.substring(newlineIndex + 2);
        }

        return input;
    }
}
