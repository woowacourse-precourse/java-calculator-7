package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Delimiters {
    private List<String> delimiters = new ArrayList<>();

    public Delimiters(CustomDelimiter customDelimiter) {
        delimiters.add(":");
        delimiters.add(",");

        if (customDelimiter.isValueExist()) {
            String value = customDelimiter.getValue();
            delimiters.add(value);
        }
    }

    public String convertToRegex() {
        return String.join("|", delimiters);
    }
}
