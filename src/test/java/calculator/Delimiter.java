package calculator;

import java.util.regex.Pattern;

public class Delimiter {
    private static final String DEFAULT_DELIMITER = "[,:]";
    private String delimiter = DEFAULT_DELIMITER;
    private String[] delimitedNumbers;

    public Delimiter(String inputString) {
        checkAndSetDelimiter(inputString);
        createDelimitedStrings(inputString);
    }

    private void checkAndSetDelimiter(String inputString) {
        if (inputString.startsWith("//")) {
            String newDelimiter = inputString.substring(2, inputString.indexOf("\\n"));
            delimiter += "|" + Pattern.quote(newDelimiter);
        }
    }

    private void createDelimitedStrings(String inputString) {
        delimitedNumbers = inputString.split(delimiter);

        if (inputString.startsWith("//")) {
            String customInputString = inputString.substring(inputString.indexOf("\\n") + 2);
            delimitedNumbers = customInputString.split(delimiter);
        }
    }

    public String[] getDelimitedNumbers() {
        return delimitedNumbers;
    }

}
