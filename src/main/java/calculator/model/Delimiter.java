package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class Delimiter {

    private final List<String> defaultDelimiters = new ArrayList<>(List.of(":", ","));
    private String customDelimiter;

    public List<String> getDefaultDelimiters() {
        return defaultDelimiters;
    }

    public String getCustomDelimiter() {
        return customDelimiter;
    }

    public void setCustomDelimiter(String customDelimiter) {
        this.customDelimiter = customDelimiter;
    }
}
