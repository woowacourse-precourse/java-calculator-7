package calculator.model.delimiter;

import calculator.validator.DuplicatedCharacterValidator;
import calculator.validator.IllegalNumericDelimiterValidator;
import java.util.ArrayList;
import java.util.List;

public class Delimiter {
    private final List<String> delimiters;

    private Delimiter(List<String> customDelimiters) {
        this.delimiters = new ArrayList<>(customDelimiters);
        delimiters.addAll(DefaultDelimiter.getDefaultDelimiters());
    }

    public List<String> getDelimiters() {
        return delimiters;
    }

    public static Delimiter createDelimiter(List<String> customDelimiter) {
        DuplicatedCharacterValidator.validate(customDelimiter);
        IllegalNumericDelimiterValidator.validate(customDelimiter);
        return new Delimiter(customDelimiter);
    }
}
