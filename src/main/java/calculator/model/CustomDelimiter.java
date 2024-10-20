package calculator.model;

import java.util.List;

public class CustomDelimiter {
    private final List<String> customDelimiters;

    private CustomDelimiter(List<String> customDelimiter) {
        customDelimiters = customDelimiter;
    }

    public List<String> getCustomDelimiters() {
        return customDelimiters;
    }

    public static CustomDelimiter createCustomDelimiter(List<String> customDelimiter) {
        return new CustomDelimiter(customDelimiter);
    }
}
