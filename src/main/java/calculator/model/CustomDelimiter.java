package calculator.model;

import java.util.List;

public class CustomDelimiter {
    private final List<String> delimiters;

    private CustomDelimiter(List<String> customDelimiter) {
        delimiters = customDelimiter;
    }

    public List<String> getDelimiters() {
        return delimiters;
    }

    public static CustomDelimiter createCustomDelimiter(List<String> customDelimiter) {
        return new CustomDelimiter(customDelimiter);
    }
}
