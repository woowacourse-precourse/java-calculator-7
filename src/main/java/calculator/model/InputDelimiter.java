package calculator.model;

import java.util.List;

public class InputDelimiter {
    private String delimiter;

    public InputDelimiter() {
        this.delimiter = "";
    }

    public void initDelimiter() {
        this.delimiter = "";
    }

    public void addDelimiter(String value) {
        this.delimiter += value;
    }

    public boolean isDelimiter(List<String> regDelimiters) {
        for (String regDeli : regDelimiters) {
            if (delimiter.equals(regDeli)) {
                return true;
            }
        }
        return false;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
