package calculator.service.strategy;

import calculator.model.CustomDelimiter;
import calculator.model.DefaultDelimiter;
import java.util.LinkedList;
import java.util.List;

public class SplitPatternGenerator {

    public String generateSplitPattern() {
        List<String> defaultDelimiters = DefaultDelimiter.getDefaultDelimiters();
        return String.join("|", defaultDelimiters);
    }

    public String generateSplitPatternWithCustomDelimiter(CustomDelimiter customDelimiter) {
        List<String> defaultAndCustomDelimiters = addAllDefaultAndCustomDelimiters(customDelimiter);
        return String.join("|", defaultAndCustomDelimiters);
    }

    private List<String> addAllDefaultAndCustomDelimiters(CustomDelimiter customDelimiter) {
        List<String> defaultAndCustomDelimiters = new LinkedList<>(customDelimiter.getCustomDelimiters());
        defaultAndCustomDelimiters.addAll(DefaultDelimiter.getDefaultDelimiters());
        return defaultAndCustomDelimiters;
    }
}
