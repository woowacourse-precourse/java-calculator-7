package calculator;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    private static final String DEFAULT_DELIMITERS = ",|:";

    public String[] parseNumbers(String input) {
        input = input.replace("\\n", "\n");

        String delimiterPattern = DEFAULT_DELIMITERS;

        if (input.startsWith("//")) {
            if (!input.contains("\n")) {
                throw new IllegalArgumentException("Invalid delimiter format.");
            }
            List<String> customDelimiters = extractDelimiters(input);
            delimiterPattern = String.join("|", customDelimiters);
            input = input.substring(input.indexOf("\n") + 1);
        }

        return input.split(delimiterPattern);
    }

    private List<String> extractDelimiters(String input) {
        List<String> delimiters = new ArrayList<>();
        String delimiterSection = input.substring(2, input.indexOf("\n"));

        for (char delimiter : delimiterSection.toCharArray()) {
            delimiters.add(Character.toString(delimiter));
        }

        return delimiters;
    }
}