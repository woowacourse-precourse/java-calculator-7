package calculator.extractor.result;

import calculator.constant.BasicDelimiter;

import java.util.Set;

public record StringDelimiterResult(String text, String customDelimiter) {

    public static StringDelimiterResult of(String text) {
        return new StringDelimiterResult(text, "");
    }

    public static StringDelimiterResult of(String text, String customDelimiter) {
        return new StringDelimiterResult(text, customDelimiter);
    }

    public Set<String> getDelimiters() {
        if (customDelimiter.isEmpty()) {
            return BasicDelimiter.getBasicDelimiters();
        }

        return BasicDelimiter.getCustomDelimiters(customDelimiter);
    }
}
