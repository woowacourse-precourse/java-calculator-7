package refactor;

import java.util.regex.Pattern;

public class Delimiter {
    private String delimiter = ",|:";
    private String inputString = "";
    private String[] delimitedNumbers;

    public Delimiter(String inputString) {

        if (inputString.startsWith("//")) {
            String newDelimiter = inputString.substring(2, inputString.indexOf("\\n"));
            delimiter += "|" + Pattern.quote(newDelimiter);
        }

        this.inputString = inputString;

        if (inputString.startsWith("//")) {
            this.inputString = inputString.substring(inputString.indexOf("\\n") + 2);
        }

        delimitedNumbers = this.inputString.split(delimiter);

    }

    public String[] getDelimitedNumbers() {
        return delimitedNumbers;
    }

}
