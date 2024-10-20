package calculator.service.strategy;

import calculator.model.delimiter.Delimiter;
import java.util.List;

public class SplitPatternGenerator {
    public String generateSplitPattern(Delimiter delimiter) {
        List<String> defaultAndCustomDelimiters = delimiter.getDelimiters();
        return String.join("|", defaultAndCustomDelimiters);
    }
}
