package calculator.delimiter;

import java.util.ArrayList;
import java.util.List;

public class Delimiter {

    private List<String> delimiters;

    public Delimiter(List<String> defaultDelimiters) {
        this.delimiters = new ArrayList<>(defaultDelimiters);
    }

    public void addDelimiter(String customDelimiter) {
        delimiters.add(customDelimiter);
    }

    public String buildDelimiterRegex() {
        return String.join("|", delimiters);
    }

}
