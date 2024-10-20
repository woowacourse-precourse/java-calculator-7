package calculator.delimiter;

import java.util.ArrayList;
import java.util.List;

public class Delimiter {

    private String separator;
    private List<String> delimiters;

    public Delimiter(String separator, List<String> defaultDelimiters) {
        this.separator = separator;
        this.delimiters = new ArrayList<>(defaultDelimiters);
    }

    public void addDelimiter(String customDelimiter) {
        delimiters.add(customDelimiter);
    }

    public String buildDelimiterRegex() {
        return String.join(separator, delimiters);
    }

}
