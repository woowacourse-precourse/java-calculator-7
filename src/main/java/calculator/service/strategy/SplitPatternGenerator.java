package calculator.service.strategy;

import calculator.model.delimiter.DefaultDelimiter;
import calculator.model.delimiter.Delimiter;
import java.util.LinkedList;
import java.util.List;

public class SplitPatternGenerator {

    public String generateSplitPattern() {
        List<String> defaultDelimiters = DefaultDelimiter.getDefaultDelimiters();
        return String.join("|", defaultDelimiters);
    }

    public String generateSplitPatternWithCustomDelimiter(Delimiter customDelimiter) {
        List<String> defaultAndCustomDelimiters = addAllDefaultAndCustomDelimiters(customDelimiter);
        return String.join("|", defaultAndCustomDelimiters);
    }

    private List<String> addAllDefaultAndCustomDelimiters(Delimiter customDelimiter) {
        List<String> defaultAndCustomDelimiters = new LinkedList<>(customDelimiter.getDelimiters());
        defaultAndCustomDelimiters.addAll(DefaultDelimiter.getDefaultDelimiters());
        return defaultAndCustomDelimiters;
    }
}
