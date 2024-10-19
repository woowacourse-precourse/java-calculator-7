package calculator;

import java.util.regex.Pattern;

public class Delimiter {
    private static final String DEFAULT_DELIMITER = "[,:]";
    private String delimiter = DEFAULT_DELIMITER;
    private final String inputString;

    public Delimiter(String inputString) {
        this.inputString = inputString;

        if (inputString.startsWith("//") && inputString.contains("\\n")) {
            String customDelimiter = inputString.substring(2, inputString.indexOf("\\n"));
            delimiter = DEFAULT_DELIMITER + "|" + Pattern.quote(customDelimiter);
        }
    }

    public String[] extractDelimitedNumbers() {
        if (inputString.startsWith("//") && inputString.contains("\\n")) {
            String customInputString = inputString.substring(inputString.indexOf("\\n") + 2);
            return customInputString.split(delimiter);
        }
        return inputString.split(delimiter);
    }
}
