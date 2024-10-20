package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Delimiters {
    private List<String> delimiters = new ArrayList<>();

    public Delimiters(CustomDelimiter customDelimiter) {
        delimiters.add(":");
        delimiters.add(",");

        if (customDelimiter != null) {
            String customDelimiterValue = customDelimiter.getValue();
            delimiters.add(customDelimiterValue);
        }
    }

    public String convertToRegex() {
        return String.join("|", delimiters);
    }
}
